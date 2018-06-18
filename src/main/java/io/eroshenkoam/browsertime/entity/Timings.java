package io.eroshenkoam.browsertime.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Timings {

    private Statistic firstPaint;
    private Statistic fullyLoaded;
    private Statistic rumSpeedIndex;

    private NavigationTiming navigationTiming;
    private PageTimings pageTimings;
    private PaintTiming paintTiming;


}
