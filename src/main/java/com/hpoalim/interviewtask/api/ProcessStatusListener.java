package com.hpoalim.interviewtask.api;

@FunctionalInterface
public interface ProcessStatusListener {

    /**
     * Called when the status of the process changes.
     *
     */
    void onStatusChange();
}
