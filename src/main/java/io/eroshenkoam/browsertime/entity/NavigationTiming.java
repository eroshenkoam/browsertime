package io.eroshenkoam.browsertime.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NavigationTiming {

    private Statistic duration;
    private Statistic startTime;
    private Statistic workerStart;
    private Statistic connectStart;
    private Statistic secureConnectionStart;
    private Statistic fetchStart;

    private Statistic requestStart;
    private Statistic responseStart;
    private Statistic responseEnd;

    private Statistic loadEventStart;
    private Statistic loadEventEnd;

    private Statistic domContentLoadedEventEnd;
    private Statistic domContentLoadedEventStart;
    private Statistic domInteractive;
    private Statistic domComplete;

    private Statistic domainLookupEnd;
    private Statistic domainLookupStart;

    private Statistic unloadEventEnd;
    private Statistic unloadEventStart;

}
