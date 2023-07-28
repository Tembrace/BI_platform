package com.tang.bibackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tang.bibackend.common.BaseResponse;
import com.tang.bibackend.common.DeleteRequest;
import com.tang.bibackend.model.dto.chart.*;
import com.tang.bibackend.model.entity.Chart;
import com.tang.bibackend.model.vo.BiResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * chart 
 * 
 * @author huoyouri
*/
public interface ChartService extends IService<Chart> {

    QueryWrapper<Chart> getQueryWrapper(ChartQueryRequest chartQueryRequest);

    /**
     * 生成图表
     */
    BaseResponse<Long> addChart(ChartAddRequest chartAddRequest, HttpServletRequest request);

    /**
     * 删除图表
     */
    BaseResponse<Boolean> deleteChart(DeleteRequest deleteRequest, HttpServletRequest request);
    
    /**
     * 更新图表
     */
    BaseResponse<Boolean> updateChart(ChartUpdateRequest chartUpdateRequest);

    /**
     * 根据ID获取图表
     */
    BaseResponse<Chart> getChartById(long id);

    /**
     * 分页查询
     */
    BaseResponse<Page<Chart>> listChartByPage(ChartQueryRequest chartQueryRequest);

    /**
     * 获得自己的图表（分页）
     */
    BaseResponse<Page<Chart>> listMyChartByPage(ChartQueryRequest chartQueryRequest, HttpServletRequest request);

    /**
     * 编辑图表
     */
    BaseResponse<Boolean> editChart(ChartEditRequest chartEditRequest, HttpServletRequest request);
    
    /**
     * 异步生成图表
     */
    BaseResponse<BiResponse>  genAsync(MultipartFile multipartFile, GenChartByAiRequest genChartByAiRequest, HttpServletRequest request);
    
    /**
     * 同步生成图表
     */
    BaseResponse<BiResponse> genSync(MultipartFile multipartFile, GenChartByAiRequest genChartByAiRequest, HttpServletRequest request);

    /**
     * 异步生成图表 by mq
     */
    BaseResponse<BiResponse> genAsyncByMq(MultipartFile multipartFile, GenChartByAiRequest genChartByAiRequest, HttpServletRequest request);

    /**
     * 处理更新图表的状态
     */
    void handleChartUpdateError(long chartId, String execMessage);
}
