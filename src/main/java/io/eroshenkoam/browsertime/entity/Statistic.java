package io.eroshenkoam.browsertime.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Statistic {

    private String median;
    private String mean;
    private String mdev;
    private String min;
    private String p10;
    private String p90;
    private String p99;
    private String max;


}
