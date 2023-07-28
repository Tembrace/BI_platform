package com.tang.bibackend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tang.bibackend.annotation.AuthCheck;
import com.tang.bibackend.common.BaseResponse;
import com.tang.bibackend.common.DeleteRequest;
import com.tang.bibackend.constant.UserConstant;
import com.tang.bibackend.model.dto.chart.*;
import com.tang.bibackend.model.entity.Chart;
import com.tang.bibackend.model.vo.BiResponse;
import com.tang.bibackend.service.ChartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 图表接口
 * 
 * @author huoyouri
 */
@RestController
@RequestMapping("/chart")
@Slf4j
public class ChartController {

    @Resource
    private ChartService chartService;
    
    /**
     * 创建
     */
    @PostMapping("/add")
    public BaseResponse<Long> addChart(@RequestBody ChartAddRequest chartAddRequest, HttpServletRequest request) {
        return chartService.addChart(chartAddRequest, request);
    }
    /**
     * 删除
     */
    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteChart(@RequestBody DeleteRequest deleteRequest, HttpServletRequest request) {
        return chartService.deleteChart(deleteRequest, request);
    }
    /**
     * 更新（仅管理员）
     */
    @PostMapping("/update")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> updateChart(@RequestBody ChartUpdateRequest chartUpdateRequest) {
        return chartService.updateChart(chartUpdateRequest);
    }
    
    /**
     * 根据 id 获取
     */
    @GetMapping("/get")
    public BaseResponse<Chart> getChartById(long id) {
        return chartService.getChartById(id);
    }

    /**
     * 分页获取列表（封装类）
     */
    @PostMapping("/list/page")
    public BaseResponse<Page<Chart>> listChartByPage(@RequestBody ChartQueryRequest chartQueryRequest) {
        return chartService.listChartByPage(chartQueryRequest);
    }

    /**
     * 分页获取当前图表创建的资源列表
     */
    @PostMapping("/my/list/page")
    public BaseResponse<Page<Chart>> listMyChartByPage(@RequestBody ChartQueryRequest chartQueryRequest,
                                                       HttpServletRequest request) {
        return chartService.listMyChartByPage(chartQueryRequest, request);
    }

    /**
     * 编辑（图表）
     */
    @PostMapping("/edit")
    public BaseResponse<Boolean> editChart(@RequestBody ChartEditRequest chartEditRequest, HttpServletRequest request) {
        return chartService.editChart(chartEditRequest, request);
    }

    /**
     * 智能分析（同步）
     */
    @PostMapping("/gen")
    public BaseResponse<BiResponse> genChartByAi(@RequestPart("file") MultipartFile multipartFile,
                                                 GenChartByAiRequest genChartByAiRequest, HttpServletRequest request) {
        return chartService.genSync(multipartFile, genChartByAiRequest, request);
    }

    /**
     * 智能分析（异步）
     */
    @PostMapping("/gen/async")
    public BaseResponse<BiResponse> genChartByAiAsync(@RequestPart("file") MultipartFile multipartFile,
                                                      GenChartByAiRequest genChartByAiRequest, HttpServletRequest request) {
        return chartService.genAsync(multipartFile, genChartByAiRequest, request);
    }

    /**
     * 智能分析（消息队列）
     */
    @PostMapping("/gen/async/mq")
    public BaseResponse<BiResponse> genChartByAiAsyncMq(@RequestPart("file") MultipartFile multipartFile,
                                                        GenChartByAiRequest genChartByAiRequest, HttpServletRequest request) {
        return chartService.genAsyncByMq(multipartFile, genChartByAiRequest, request);
    }
}
