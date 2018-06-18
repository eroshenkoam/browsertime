package io.eroshenkoam.browsertime.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageInfo {

    private Statistic documentHeight;
    private DocumentSize documentSize;
    private Statistic documentWidth;

}
