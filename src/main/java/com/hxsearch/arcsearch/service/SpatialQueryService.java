package com.hxsearch.arcsearch.service;

import com.hxsearch.arcsearch.exception.ExceptionMsg;
import com.hxsearch.arcsearch.request.QueryParameter;
import com.hxsearch.arcsearch.respose.Features;

import java.rmi.RemoteException;

/**
 * 功能描述：
 *
 * @Author: ddw
 * @Date: 2021/8/9 15:06
 */
public interface SpatialQueryService {
    Features search(QueryParameter queryParameter) throws RemoteException, ExceptionMsg;
    Features getFeaturesByCityCode(QueryParameter queryParameter,String cityCode,String cityTable);
}
