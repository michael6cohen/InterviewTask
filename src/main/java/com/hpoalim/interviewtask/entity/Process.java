package com.hpoalim.interviewtask.entity;

import com.hpoalim.interviewtask.type.ProcessStatusType;
import com.hpoalim.interviewtask.util.TaskUtils;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.UUID;

import static com.hpoalim.interviewtask.type.ProcessStatusType.PENDING;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Process implements Serializable {

    private String processName;

    public Process(String processName) {
        this.processId = UUID.randomUUID();
        this.processName = TaskUtils.getDefaultTaskName(processName, getProcessIdAsString());
        this.status = PENDING;
        this.ttl = TaskUtils.getRandomTTL();
        this.timeOfLiveInSeconds = ttl;
    }

    private UUID processId;
    private ProcessStatusType status;
    private int ttl;
    private int timeOfLiveInSeconds;
    private int progressPercent;

    public String getProcessIdAsString() {
        return processId.toString();
    }
}
