package io.eroshenkoam.browsertime.coach;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoachAdvice {

    private AdviceGroup accessibility;
    private AdviceGroup bestpractice;
    private AdviceGroup performance;

    private Info info;

    private String score;

}
