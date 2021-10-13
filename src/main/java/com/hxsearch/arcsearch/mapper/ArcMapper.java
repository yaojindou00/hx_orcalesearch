package com.hxsearch.arcsearch.mapper;

import com.hxsearch.arcsearch.request.QueryParameter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 功能描述：
 *
 * @Author: ddw
 * @Date: 2021/8/9 15:19
 */
@Repository
@org.apache.ibatis.annotations.Mapper
public interface ArcMapper {
    List<Map<String, Object>> search(QueryParameter queryParameter);
    Integer getFeatureCounts(@Param("layerName") String layerName);
    List<Map> getLayerFields(@Param("layerName")String layerName);
    List<Map<String,Object>>getFeaturesByCityCode(@Param("queryParameter")QueryParameter  queryParameter,@Param("cityCode")String cityCode,@Param("cityTable")String cityTable);
}
