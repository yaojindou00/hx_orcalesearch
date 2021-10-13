package com.hxsearch.arcsearch.st_geometry;
import com.hxsearch.arcsearch.mapper.ArcMapper;
import com.hxsearch.arcsearch.request.QueryParameter;
import com.hxsearch.arcsearch.respose.CallbackAbleFeature;
import com.hxsearch.arcsearch.respose.Features;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.sql.Clob;
import java.util.List;
import java.util.Map;

/**
 * 功能描述：
 *
 * @Author: ddw
 * @Date: 2021/8/9 15:10
 */
@Component
public class ArcSearch {
    private static final Logger logger = LoggerFactory.getLogger(ArcSearch.class);
    @Resource
    ArcMapper arcMapper;
    public Features search(QueryParameter queryParameter) {
        List<Map<String, Object>> mapData= arcMapper.search(queryParameter);
        return getFeaturesByMaps(mapData,queryParameter);
    }
    public Features getFeaturesByCityCode(QueryParameter queryParameter,String cityCode,String cityTable){
        List<Map<String, Object>> mapData= arcMapper.getFeaturesByCityCode(queryParameter,cityCode,cityTable);
        return getFeaturesByMaps(mapData,queryParameter);
    }
    public Features getFeaturesByMaps(List<Map<String, Object>> mapData,QueryParameter queryParameter) {
        Features pFeatures = new Features();
        try {
            pFeatures.setLayerName(queryParameter.getLayerName());
            pFeatures.setAllCount(mapData.size());
            Integer counts = arcMapper.getFeatureCounts(queryParameter.getLayerName());
            pFeatures.setMaxRecordCount(counts);
            if (mapData.size() > 0) {
                mapData.forEach(item -> {
                    CallbackAbleFeature pFeature = new CallbackAbleFeature();
                    if (item.size() > 0) {
                        for (Object k : item.keySet()) {
                            if (k.toString().toLowerCase().equals("geo")) {
                                try {
                                    String values = item.get(k) instanceof Clob ? FeaturesUtils.ClobToString((Clob) item.get(k)) : item.get(k).toString();
                                    String vjson=FeaturesUtils.ConvertWktToGeojson(values);
                                    pFeature.setGeowkt(vjson);
                                } catch (Exception ex) {
                                    System.out.println("构建几何体出错");
                                }

                            } else {
                                pFeature.setAttribute(k.toString(), item.get(k));
                            }
                        }
                    }
                    pFeatures.addFeature(pFeature);
                });
            }
        } catch (Exception ex) {
            System.out.println("创建要素图层出错 ：" + ex.getMessage());
        }
        return  pFeatures;
    }

}
