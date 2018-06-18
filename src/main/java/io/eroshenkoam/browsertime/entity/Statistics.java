package io.eroshenkoam.browsertime.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Statistics {

    private PageInfo pageinfo;

    private Timings timings;

    private VisualMetrics visualMetrics;

}
