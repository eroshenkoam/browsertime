package io.eroshenkoam.browsertime.browsertime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentSize {

    private Statistic decodedBodySize;
    private Statistic encodedBodySize;
    private Statistic transferSize;

}
