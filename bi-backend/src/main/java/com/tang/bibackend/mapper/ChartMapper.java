package com.tang.bibackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tang.bibackend.model.entity.Chart;

import java.util.List;
import java.util.Map;

/**
 * chart
 * 
 * @author huoyouri
*/
public interface ChartMapper extends BaseMapper<Chart> {
    
    List<Map<String, Object>> queryChartData(String querySql);
}




