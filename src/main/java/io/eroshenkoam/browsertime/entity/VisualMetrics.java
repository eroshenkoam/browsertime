package io.eroshenkoam.browsertime.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VisualMetrics {

    @JsonProperty("SpeedIndex")
    private Statistic speedIndex;
    @JsonProperty("PerceptualSpeedIndex")
    private Statistic perceptualSpeedIndex;
    @JsonProperty("FirstVisualChange")
    private Statistic firstVisualChange;
    @JsonProperty("LastVisualChange")
    private Statistic lastVisualChange;
    @JsonProperty("VisualReadiness")
    private Statistic visualReadiness;
    @JsonProperty("VisualComplete85")
    private Statistic visualComplete85;
    @JsonProperty("VisualComplete95")
    private Statistic visualComplete95;
    @JsonProperty("VisualComplete99")
    private Statistic visualComplete99;

}
