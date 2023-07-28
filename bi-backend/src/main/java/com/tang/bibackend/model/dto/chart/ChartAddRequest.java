package com.tang.bibackend.model.dto.chart;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 创建请求
 *
 * @author huoyouri
 */
@Data
public class ChartAddRequest implements Serializable {

    /**
     * 名称
     */
    private String chartName;

    /**
     * 分析目标
     */
    private String goal;

    /**
     * 图表信息
     */
    private String chartData;

    /**
     * 图表类型
     */
    private String chartType;
}
