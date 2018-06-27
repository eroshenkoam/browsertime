package io.eroshenkoam.browsertime.browsertime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrowsertimeReport {

    private Info info;

    private Statistics statistics;

}
