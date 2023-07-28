package com.tang.bibackend.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Bi 的返回结果
 * 
 * @author huoyouri
 */
@Data
public class BiResponse implements Serializable {

    private String genChart;

    private String genResult;

    private Long chartId;

}
