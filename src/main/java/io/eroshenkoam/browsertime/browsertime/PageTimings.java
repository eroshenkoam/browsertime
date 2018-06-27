package io.eroshenkoam.browsertime.browsertime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageTimings {

    private Statistic backEndTime;
    private Statistic domContentLoadedTime;
    private Statistic domInteractiveTime;
    private Statistic domainLookupTime;
    private Statistic frontEndTime;
    private Statistic pageDownloadTime;
    private Statistic pageLoadTime;
    private Statistic serverConnectionTime;
    private Statistic serverResponseTime;

}

