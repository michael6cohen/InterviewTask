package com.hpoalim.interviewtask.api;

public interface SwaggerProp {

    String GET_TASKS_SUMMARY = "Get all sub processes by task ID";
    String GET_TASKS_DESC = "Returns the list of processes and their statuses for the given task ID";

    String CREATE_TASKS_SUMMARY = "Create new task with sub-processes";
    String CREATE_TASKS_DESC = "Creates a new task, each with a set of sub-processes that are run asynchronously";

    String TASK_NAME_DESC = "The name of the task to be created";
    String TASK_NAME_EX = "Sample Task";

    String NUMBER_OF_PROCESSES_DESC = "The number of sub processes to be created for the task";
    String NUMBER_OF_PROCESSES_EX = "100";

    String TASK_ID_DESC = "The ID of the task to retrieve";
    String TASK_ID_EX = "63047d2e-c7a4-4f12-8609-47f64bc34105";
}
