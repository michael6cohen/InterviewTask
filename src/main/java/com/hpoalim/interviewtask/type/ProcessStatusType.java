package com.hpoalim.interviewtask.type;

import lombok.Getter;

@Getter
public enum ProcessStatusType {
    PENDING("PENDING"),
    RUNNING("RUNNING"),
    FAILED("FAILED"),
    COMPLETED("COMPLETED");

    private final String status;

    ProcessStatusType(String status) {
        this.status = status;
    }
}
