package io.eroshenkoam.browsertime.coach;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentTypes {

    private ContentType css;

    private ContentType image;

    private ContentType javascript;

}
