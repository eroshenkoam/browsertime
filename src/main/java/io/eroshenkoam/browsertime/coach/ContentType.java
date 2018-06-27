package io.eroshenkoam.browsertime.coach;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentType {

    private String requests;
    private String contentSize;
    private String transferSize;

}
