package com.hpoalim.interviewtask.controller;

import com.hpoalim.interviewtask.dto.request.CreateTaskDto;
import com.hpoalim.interviewtask.dto.response.CreateTaskDTO;
import com.hpoalim.interviewtask.dto.response.TasksDTO;
import com.hpoalim.interviewtask.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.hpoalim.interviewtask.api.SwaggerProp.*;

@Slf4j
@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
@Tag(name = "Tasks", description = "API for managing tasks and processes")
public class TaskController {

    private TaskService taskService;

    @GetMapping(value = "/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = GET_TASKS_SUMMARY, description = GET_TASKS_DESC)
    public ResponseEntity<TasksDTO> getTasks(@PathVariable @Valid @NotEmpty @Parameter(
            description = TASK_ID_DESC,
            example = TASK_ID_EX,
            required = true
    ) String taskId) {
        TasksDTO result = taskService.getTasks(taskId);
        return ResponseEntity.ok(result);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = CREATE_TASKS_SUMMARY, description = CREATE_TASKS_DESC)
    public ResponseEntity<CreateTaskDTO> createTasks(@RequestBody @Valid CreateTaskDto storeRoute) {
        String results = taskService.createTask(storeRoute);
        return ResponseEntity.ok(new CreateTaskDTO(results));
    }
}
