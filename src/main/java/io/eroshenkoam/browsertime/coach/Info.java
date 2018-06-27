package io.eroshenkoam.browsertime.coach;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {

    private String pageRequests;
    private String pageContentSize;
    private String pageTransferSize;

    private ContentTypes pageContentTypes;

}
