package com.hpoalim.interviewtask.dto.response;


import com.hpoalim.interviewtask.type.ProcessStatusType;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.Builder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProcessDTO {
    private String processName;
    private String processId;
    private ProcessStatusType status;
    private int timeOfLiveInSeconds;
    private int progressPercent;
}
