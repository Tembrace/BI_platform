package com.tang.bibackend.constant;

import java.util.Arrays;
import java.util.List;

/**
 * 文件常量
 *
 * @author huoyouri
 */
public interface FileConstant {

    /**
     * 文件大小 1M
     */
    long FILE_MAX_SIZE = 1 * 1024 * 1024L;

    /**
     * 文件后缀白名单
     */
    List<String> VALID_FILE_SUFFIX = Arrays.asList("xlsx", "csv", "xls", "json");

    /**
     * 超时时间 = 100s
     */
    long TIME_OUT = 1000 * 100L;
}
