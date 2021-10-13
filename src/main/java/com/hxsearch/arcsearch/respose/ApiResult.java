package com.hxsearch.arcsearch.respose;

import lombok.Data;

import java.io.Serializable;

/**
 * 功能描述：
 *
 * @Author: ddw
 * @Date: 2021/8/9 10:22
 */
@Data
public class ApiResult implements Serializable {
    //请求结果
    private boolean isSucceed = true;
    //请求状态
    private int code = 200;
    //请求信息
    private String message = "";
    //请求结果数据
    private Object data = new Object();
    public ApiResult(){}
    public ApiResult(boolean isSucceed, int code, String message, Object data){
        this.isSucceed=isSucceed;
        this.code=code;
        this.data=data;
        this.message=message;
    }
}

