package com.hxsearch.arcsearch.service.impl;

import com.hxsearch.arcsearch.exception.ExceptionMsg;
import com.hxsearch.arcsearch.request.QueryParameter;
import com.hxsearch.arcsearch.respose.Features;
import com.hxsearch.arcsearch.service.SpatialQueryService;
import com.hxsearch.arcsearch.st_geometry.ArcSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

/**
 * 功能描述：
 *
 * @Author: ddw
 * @Date: 2021/8/9 15:06
 */
@Service
public class SpatialQueryServiceImpl implements SpatialQueryService {
    @Autowired
    private ArcSearch arcSearch;
    @Override
    public Features search(QueryParameter queryParameter) throws RemoteException, ExceptionMsg {
        Features features= arcSearch.search(queryParameter);
        return features;
    }

    @Override
    public Features getFeaturesByCityCode(QueryParameter queryParameter, String cityCode,String cityTable) {
        Features features=arcSearch.getFeaturesByCityCode(queryParameter,cityCode,cityTable);
        return features;
    }



}
