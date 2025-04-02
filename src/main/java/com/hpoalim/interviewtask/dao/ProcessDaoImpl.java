package com.hpoalim.interviewtask.dao;

import com.hpoalim.interviewtask.entity.Process;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Repository
public class ProcessDaoImpl implements ProcessDao {

    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public void saveProcessByTaskId(String taskId, Process process) {
        String processId = process.getProcessIdAsString();
        redisTemplate.opsForHash().put(taskId, processId, process);
    }

    @Override
    public List<Process> listProcessByTaskId(String taskId) {
        Map<Object, Object> processMap = redisTemplate.opsForHash().entries(taskId);
        return processMap.values().stream()
                .filter(Objects::nonNull)
                .map(value -> (Process) value)
                .collect(Collectors.toList());
    }
}
