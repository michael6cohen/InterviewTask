package com.hpoalim.interviewtask.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import static com.hpoalim.interviewtask.api.SwaggerProp.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateTaskDto {

    @Length(min = 1, max = 50)
    @Schema(description = TASK_NAME_DESC, example = TASK_NAME_EX, minLength = 1, maxLength = 50, nullable = true)
    private String taskName;

    @Min(1)
    @NotNull
    @Schema(description = NUMBER_OF_PROCESSES_DESC, example = NUMBER_OF_PROCESSES_EX, minimum = "1", nullable = false)
    private Integer numberOfProcesses;
}
