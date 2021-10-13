package com.hxsearch.arcsearch.respose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：
 *
 * @Author: ddw
 * @Date: 2021/8/9 10:28
 */
public class Features implements Serializable {
    /**
     * 图层名称
     */
    private String layerName = null;

    /**
     * 返回记录
     */
    private List<CallbackAbleFeature> features = new ArrayList<CallbackAbleFeature>();
    /**
     * 图层字段列表
     */
    private List<Field> fields = new ArrayList<Field>();
    /**
     * 本次查询的总记录条数
     */
    private int allCount = 0;
    /**
     * 最大返回记录数
     */
    private int maxRecordCount = 100000;
    /**
     * 是否达到最大记录数
     */
    private boolean isMax = false;
    /**
     * 几何体类型
     */
    private String geometryType = "";
    public void setGeometryType(String geometryType) {
        this.geometryType = geometryType;
    }
    public String getGeometryType() {
        return geometryType;
    }

    public String getLayerName() {
        return layerName;
    }

    public void setLayerName(String layerName) {
        this.layerName = layerName;
    }

    public List<CallbackAbleFeature> getFeatures() {
        return features;
    }

    public void setFeatures(List<CallbackAbleFeature> features) {
        this.features = features;
    }

    public int getMaxRecordCount() {
        return maxRecordCount;
    }

    public void setMaxRecordCount(int maxRecordCount) {
        this.maxRecordCount = maxRecordCount;
    }

    public boolean isMax() {
        return isMax;
    }

    public void setMax(boolean isMax) {
        this.isMax = isMax;
    }

    public int getAllCount() {
        return allCount;
    }

    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }

    public void addFeature(CallbackAbleFeature feat) {
        this.features.add(feat);
    }

    private void addFields(Field field) {
        this.fields.add(field);
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

}
