package com.hpoalim.interviewtask.service;

import com.hpoalim.interviewtask.api.ProcessStatusListener;
import com.hpoalim.interviewtask.entity.Process;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

import static com.hpoalim.interviewtask.type.ProcessStatusType.*;

@Slf4j
@Service
public class ProcessExecutor {

    @Async
    public void execute(Process process, ProcessStatusListener listener) {
        String processId = process.getProcessIdAsString();
        try {
            log.info("Executing process: {}", processId);
            process.setStatus(RUNNING);
            listener.onStatusChange();

            int ttl = process.getTtl();
            for (int i = 0; i < ttl; i++) {
                process.setProgressPercent((i + 1) * 100 / ttl);
                process.setTimeOfLiveInSeconds(ttl - i - 1);
                listener.onStatusChange();
                TimeUnit.SECONDS.sleep(1);
            }

            log.info("Process {} completed successfully", processId);
            process.setStatus(COMPLETED);
            listener.onStatusChange();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            process.setStatus(FAILED);
            log.error("Process {} interrupted", processId);
            listener.onStatusChange();
        }
    }
}
