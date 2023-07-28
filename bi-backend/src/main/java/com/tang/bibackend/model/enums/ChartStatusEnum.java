package com.tang.bibackend.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * chart枚举
 *
 * @author huoyouri
 */
public enum ChartStatusEnum {
    
    RUNNING("生成中", "running"),
    SUCCEED("成功生成", "succeed"),
    FAILED("生成失败", "failed");

    private final String text;

    private final String value;

    ChartStatusEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 获取值列表
     *
     * @return
     */
    public static List<String> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
