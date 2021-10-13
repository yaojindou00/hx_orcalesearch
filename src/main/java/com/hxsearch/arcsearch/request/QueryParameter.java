package com.hxsearch.arcsearch.request;

import com.hxsearch.arcsearch.exception.ExceptionMsg;

/**
 * 功能描述：
 *
 * @Author: ddw
 * @Date: 2021/8/9 9:31
 */
public class QueryParameter extends ValidParameter {

    /**
     * 图层名称
     */
    protected String layerName;
    /**
     * 属性过滤条件
     */
    protected String filter;
    /**
     * 空间过滤条件
     */
    protected String spatialFilter;
    /**
     * 返回的字段名
     */
    protected String outFields;
    /**
     * 是否返回空间信息
     */
    protected boolean isReturnGeometry = true;
    /**
     * 排序规则 例如：ORDER BY ID DESC,NAME
     */
    protected String orderByFields;
    /**
     * 空间位置关系
     */
    //SpatialRel spatialRel = SpatialRel.INTERSECTS;
    protected String spatialRel;
    /**
     * 缓冲距离
     */
    protected Integer buffDis;

    /**
     * 分页信息
     */
    protected Integer current=1;

    protected Integer limit=1000;

    @Override
    public boolean check() throws ExceptionMsg {
        ValidParameter.isBlank(this.layerName, "'layerName'参数不能为空!");
        return false;
    }
    public QueryParameter(String layerName, String filter, String spatialFilter, String outFields, Boolean isReturnGeometry, String orderByFields,  String spatialRel, Integer current, Integer limit){
     this.layerName=layerName;
     this.filter=filter;
     this.spatialFilter=spatialFilter;
     this.outFields=outFields;
     this.isReturnGeometry=isReturnGeometry;
     this.orderByFields=orderByFields;
     this.spatialRel=spatialRel;
     this.current=current;
     this.limit=limit;
    }

    public String getLayerName() {
        return layerName;
    }

    public void setLayerName(String layerName) {
        this.layerName = layerName;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getSpatialFilter() {
        return spatialFilter;
    }

    public void setSpatialFilter(String spatialFilter) {
        this.spatialFilter = spatialFilter;
    }

    public String getOutFields() {
        return outFields;
    }

    public void setOutFields(String outFields) {
        this.outFields = outFields;
    }

    public boolean isReturnGeometry() {
        return isReturnGeometry;
    }

    public void setReturnGeometry(boolean returnGeometry) {
        isReturnGeometry = returnGeometry;
    }

    public String getOrderByFields() {
        return orderByFields;
    }

    public void setOrderByFields(String orderByFields) {
        this.orderByFields = orderByFields;
    }

//    public SpatialRel getSpatialRel() {
//        return spatialRel;
//    }
//
//    public void setSpatialRel(SpatialRel spatialRel) {
//        this.spatialRel = spatialRel;
//    }


    public void setSpatialRel(String spatialRel) {
        this.spatialRel = spatialRel;
    }

    public String getSpatialRel() {
        return spatialRel;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getBuffDis() {
        return buffDis;
    }

    public void setBuffDis(Integer buffDis) {
        this.buffDis = buffDis;
    }

}
