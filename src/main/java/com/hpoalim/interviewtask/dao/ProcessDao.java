package com.hpoalim.interviewtask.dao;

import com.hpoalim.interviewtask.entity.Process;

import java.util.List;

public interface ProcessDao {

    void saveProcessByTaskId(String taskId, Process process);

    List<Process> listProcessByTaskId(String taskId);
}
