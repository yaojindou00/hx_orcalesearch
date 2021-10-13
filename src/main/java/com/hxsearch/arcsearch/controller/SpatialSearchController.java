package com.hxsearch.arcsearch.controller;
import com.hxsearch.arcsearch.exception.ExceptionMsg;
import com.hxsearch.arcsearch.request.QueryParameter;
import com.hxsearch.arcsearch.request.SpatialRel;
import com.hxsearch.arcsearch.respose.ApiResult;
import com.hxsearch.arcsearch.respose.Features;
import com.hxsearch.arcsearch.service.SpatialQueryService;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.WKTReader;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.rmi.RemoteException;

/**
 * 功能描述：
 *
 * @Author: ddw
 * @Date: 2021/8/6 10:23
 */
@RestController
@RequestMapping("rest")
@Api(tags = "空间数据查询REST实现")
public class SpatialSearchController {
    @Resource
    SpatialQueryService spatialQueryService;
    @RequestMapping(value = "api/search", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "layerName", required = true, dataType = "String", value = "空间数据库中的图层名称"),
            @ApiImplicitParam(paramType = "query", name = "filter", required = false, dataType = "String", value = "属性过滤条件，语法请参考SQL，例如：LXBM='G45' AND SXXFX=1"),
            @ApiImplicitParam(paramType = "query", name = "spatialFilter", required = false, dataType = "String", value = "空间过滤条件，标准的WKT"),
            @ApiImplicitParam(paramType = "query", name = "outFields", required = false, dataType = "String", value = "查询返回的字段,例如：LXBM,LXMC"),
            @ApiImplicitParam(paramType = "query", name = "isReturnGeometry", required = true, dataType = "Boolean", value = "是否返回空间数据"),
            @ApiImplicitParam(paramType = "query", name = "orderByFields", required = false, dataType = "String", value = "排序条件，语法参考SQL，例如：ORDER BY NAME DESC"),
            @ApiImplicitParam(paramType = "query", name = "spatialRel", required = true, dataType = "String", allowableValues = "INTERSECTS,CONTAINS,DISJOINT,TOUCHES,CROSSES,WITHIN,OVERLAPS", value = "空间位置关系"),
            @ApiImplicitParam(paramType = "query", name = "current", required = false, dataType = "String", value = "分页参数，第几页，不传此参数默认不分页，开始页数为1"),
            @ApiImplicitParam(paramType = "query", name = "limit", required = false, dataType = "String", value = "每页记录数，此参数可选，默认为全部")})
    public ApiResult search(@RequestParam(value = "layerName", required = true) String layerName,
                            @RequestParam(value = "filter", required = false) String filter,
                            @RequestParam(value = "spatialFilter", required = false) String spatialFilter,
                            @RequestParam(value = "outFields", required = false) String outFields,
                            @RequestParam(value = "isReturnGeometry", required = true) Boolean isReturnGeometry,
                            @RequestParam(value = "orderByFields", required = false) String orderByFields,
                            @RequestParam(value = "spatialRel", required = false) String spatialRel,
                            @RequestParam(value = "current", required = false, defaultValue = "1") Integer current,
                            @RequestParam(value = "limit", required = false, defaultValue = "1000") Integer limit) throws RemoteException, ExceptionMsg {
        ApiResult apiData = new ApiResult();

        QueryParameter queryParameter = new QueryParameter(layerName, filter, spatialFilter, outFields, isReturnGeometry, orderByFields, spatialRel, current, limit);
        Features pFeatures = spatialQueryService.search(queryParameter);
        apiData.setCode(200);
        apiData.setData(pFeatures);
        return apiData;
    }
    @RequestMapping(value = "api/bufferSearch", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "layerName", required = true, dataType = "String", value = "空间数据库中的图层名称"),
            @ApiImplicitParam(paramType = "query", name = "filter", required = false, dataType = "String", value = "属性过滤条件，语法请参考SQL，例如：LXBM='G45' AND SXXFX=1"),
            @ApiImplicitParam(paramType = "query", name = "spatialFilter", required = false, dataType = "String", value = "空间过滤条件，标准的WKT"),
            @ApiImplicitParam(paramType = "query", name = "bufferRadius", required = false, dataType = "Double", value = "1"),
            @ApiImplicitParam(paramType = "query", name = "outFields", required = false, dataType = "String", value = "查询返回的字段,例如：LXBM,LXMC"),
            @ApiImplicitParam(paramType = "query", name = "isReturnGeometry", required = true, dataType = "Boolean", value = "是否返回空间数据"),
            @ApiImplicitParam(paramType = "query", name = "orderByFields", required = false, dataType = "String", value = "排序条件，语法参考SQL，例如：ORDER BY NAME DESC"),
            @ApiImplicitParam(paramType = "query", name = "spatialRel", required = true, dataType = "String", allowableValues = "INTERSECTS,CONTAINS,DISJOINT,TOUCHES,CROSSES,WITHIN,OVERLAPS", value = "空间位置关系"),
            @ApiImplicitParam(paramType = "query", name = "current", required = false, dataType = "String", value = "分页参数，第几页，不传此参数默认不分页，开始页数为1"),
            @ApiImplicitParam(paramType = "query", name = "limit", required = false, dataType = "String", value = "每页记录数，此参数可选，默认为全部")})
    public ApiResult bufferSearch(@RequestParam(value = "layerName", required = true) String layerName,
                                  @RequestParam(value = "filter", required = false) String filter,
                                  @RequestParam(value = "spatialFilter", required = false) String spatialFilter,
                                  @RequestParam(value = "bufferRadius", required = false) Double bufferRadius,
                                  @RequestParam(value = "outFields", required = false) String outFields,
                                  @RequestParam(value = "isReturnGeometry", required = true) Boolean isReturnGeometry,
                                  @RequestParam(value = "orderByFields", required = false) String orderByFields,
                                  @RequestParam(value = "spatialRel", required = false) String spatialRel,
                                  @RequestParam(value = "current", required = false, defaultValue = "1") Integer current,
                                  @RequestParam(value = "limit", required = false, defaultValue = "1000") Integer limit) {
        ApiResult apiData = new ApiResult();
        Geometry geometry = null;
        SpatialRel spRel = null;
        try {
            if (spatialFilter != null && spatialFilter != "") {
                if (spatialFilter != null) {
                    WKTReader reader = new WKTReader();
                    geometry = reader.read(spatialFilter);
                }
                if (bufferRadius != -1) {
                    geometry = geometry.buffer(bufferRadius);
                    spatialFilter=geometry.toText();
                    System.out.println(spatialFilter);
                }

                QueryParameter queryParameter = new QueryParameter(layerName, filter, spatialFilter, outFields, isReturnGeometry, orderByFields, spatialRel, current, limit);
                Features pFeatures = spatialQueryService.search(queryParameter);
                apiData.setCode(200);
                apiData.setData(pFeatures);
            }
        } catch (Exception ex) {
            System.out.println("缓冲区查询出错： " + ex.getMessage());

        }
        return apiData;
    }
    @RequestMapping(value = "api/getFeaturesByCityCode", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "layerName", required = true, dataType = "String", value = "空间数据库中的图层名称"),
            @ApiImplicitParam(paramType = "query", name = "filter", required = false, dataType = "String", value = "属性过滤条件，语法请参考SQL，例如：LXBM='G45' AND SXXFX=1"),
            @ApiImplicitParam(paramType = "query", name = "spatialFilter", required = false, dataType = "String", value = "空间过滤条件，标准的WKT"),
            @ApiImplicitParam(paramType = "query", name = "cityCode", required = true, dataType = "String", value = "行政区编码"),
            @ApiImplicitParam(paramType = "query", name = "cityTable", required = true, dataType = "String", value = "行政区table"),
            @ApiImplicitParam(paramType = "query", name = "outFields", required = false, dataType = "String", value = "查询返回的字段,例如：LXBM,LXMC"),
            @ApiImplicitParam(paramType = "query", name = "isReturnGeometry", required = true, dataType = "Boolean", value = "是否返回空间数据"),
            @ApiImplicitParam(paramType = "query", name = "orderByFields", required = false, dataType = "String", value = "排序条件，语法参考SQL，例如：ORDER BY NAME DESC"),
            @ApiImplicitParam(paramType = "query", name = "spatialRel", required = true, dataType = "String", allowableValues = "INTERSECTS,CONTAINS,DISJOINT,TOUCHES,CROSSES,WITHIN,OVERLAPS", value = "空间位置关系"),
            @ApiImplicitParam(paramType = "query", name = "current", required = false, dataType = "String", value = "分页参数，第几页，不传此参数默认不分页，开始页数为1"),
            @ApiImplicitParam(paramType = "query", name = "limit", required = false, dataType = "String", value = "每页记录数，此参数可选，默认为全部")})
    public ApiResult getFeaturesByCityCode(@RequestParam(value = "layerName", required = true) String layerName,
                                           @RequestParam(value = "filter", required = false) String filter,
                                           @RequestParam(value = "spatialFilter", required = false) String spatialFilter,
                                           @RequestParam(value = "cityCode", required = false) String cityCode,
                                           @RequestParam(value = "cityTable", required = false) String cityTable,
                                           @RequestParam(value = "outFields", required = false) String outFields,
                                           @RequestParam(value = "isReturnGeometry", required = true) Boolean isReturnGeometry,
                                           @RequestParam(value = "orderByFields", required = false) String orderByFields,
                                           @RequestParam(value = "spatialRel", required = false) String spatialRel,
                                           @RequestParam(value = "current", required = false, defaultValue = "1") Integer current,
                                           @RequestParam(value = "limit", required = false, defaultValue = "1000") Integer limit) {
        ApiResult apiData=new ApiResult();
        try{
            SpatialRel spRel = null;
            if (!spatialRel.isEmpty()) {
                spRel = SpatialRel.fromName(spatialRel);
            }
            QueryParameter queryParameter = new QueryParameter(layerName, filter, spatialFilter, outFields, isReturnGeometry, orderByFields, spatialRel, current, limit);
            Features pFeatures = spatialQueryService.getFeaturesByCityCode(queryParameter,cityCode,cityTable);
            apiData.setData(pFeatures);
            apiData.setCode(200);
        }catch (Exception ex){
            System.out.println("行政区查询失败 :"+ex.getMessage());
        }
        return apiData;
    }
}
