package com.tang.bibackend.model.dto.chart;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 编辑请求
 *
 * @author huoyouri
 */
@Data
public class ChartEditRequest implements Serializable {

    /**
     * 名称
     */
    private String chartName;

    /**
     * id
     */
    private Long id;

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
