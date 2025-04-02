package com.hpoalim.interviewtask.service;

import com.hpoalim.interviewtask.dao.ProcessDao;
import com.hpoalim.interviewtask.dto.request.CreateTaskDto;
import com.hpoalim.interviewtask.dto.response.ProcessDTO;
import com.hpoalim.interviewtask.dto.response.TasksDTO;
import com.hpoalim.interviewtask.entity.Process;
import com.hpoalim.interviewtask.type.ProcessStatusType;
import com.hpoalim.interviewtask.util.TaskUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class TaskService {

    private final ProcessDao processDao;
    private final ProcessExecutor processExecutor;

    public String createTask(CreateTaskDto request) {
        String taskId = UUID.randomUUID().toString();
        log.info("Creating task {}", taskId);

        Integer numberOfProcesses = request.getNumberOfProcesses();
        String taskName = TaskUtils.getDefaultTaskName(request.getTaskName(), taskId);

        Map<String, Process> subProcessMap = buildSubProcessMap(taskName, numberOfProcesses);
        log.info("Creating {} processes for task {}", numberOfProcesses, taskId);

        subProcessMap.forEach((processId, process) -> saveProcess(taskId, process));
        subProcessMap.forEach((processId, process) -> executeSubProcess(taskId, process));
        return taskId;
    }

    private Map<String, Process> buildSubProcessMap(String taskName, Integer numberOfProcesses) {
        Map<String, Process> processMap = new HashMap<>(numberOfProcesses);
        for (int i = 0; i < numberOfProcesses; i++) {
            Process process = new Process(taskName + "-" + i);
            processMap.put(process.getProcessIdAsString(), process);
        }
        return processMap;
    }

    public void executeSubProcess(String taskId, Process process) {
        processExecutor.execute(process, () -> saveProcess(taskId, process));
    }

    public void saveProcess(String taskId, Process process) {
        String processId = process.getProcessIdAsString();
        ProcessStatusType status = process.getStatus();
        log.info("Save process {} with status {} for task {}", processId, status, taskId);
        processDao.saveProcessByTaskId(taskId, process);
    }

    public TasksDTO getTasks(String taskId) {
        List<ProcessDTO> listProcess = processDao.listProcessByTaskId(taskId).stream()
                .map(process -> ProcessDTO.builder()
                        .processId(process.getProcessIdAsString())
                        .processName(process.getProcessName())
                        .status(process.getStatus())
                        .timeOfLiveInSeconds(process.getTimeOfLiveInSeconds())
                        .progressPercent(process.getProgressPercent())
                        .build())
                .collect(Collectors.toList());

        return TasksDTO.builder()
                .listProcess(listProcess)
                .build();
    }
}
