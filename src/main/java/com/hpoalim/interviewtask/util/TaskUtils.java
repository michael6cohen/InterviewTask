package com.hpoalim.interviewtask.util;

public class TaskUtils {

    private static final int DEFAULT_START_TTL = 5;
    private static final int DEFAULT_END_TTL = 10;

    public static int getRandomTTL() {
        return getRandomTTL(DEFAULT_START_TTL, DEFAULT_END_TTL);
    }

    public static int getRandomTTL(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }

    public static String getDefaultTaskName(String taskName, String taskId) {
        if (taskId == null) {
            return taskName;
        }
        return taskName != null ? taskName : taskId.substring(0, 8);
    }
}
