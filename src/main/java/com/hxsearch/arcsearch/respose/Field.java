package com.hxsearch.arcsearch.respose;

import java.io.Serializable;

/**
 * 功能描述：
 *
 * @Author: ddw
 * @Date: 2021/8/9 10:28
 */
public class Field implements Serializable {
    /**
     * .字段标注
     */
    private String label = "";

    /**
     * .字段名称
     */
    private String name = "";

    /**
     * .字段类型
     */
    private String type = "";
    public Field() {
    }

    public Field(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Field(String name, String type, String label) {
        this.name = name;
        this.type = type;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
