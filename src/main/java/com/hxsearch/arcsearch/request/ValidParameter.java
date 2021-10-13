package com.hxsearch.arcsearch.request;

import java.io.Serializable;

import com.hxsearch.arcsearch.exception.ExceptionMsg;
import org.apache.commons.lang3.StringUtils;
/**
 * 功能描述：
 *
 * @Author: ddw
 * @Date: 2021/8/6 15:17
 */
public abstract class ValidParameter implements Serializable {
    public abstract boolean check() throws ExceptionMsg;

    public static void isNull(Object value, String message) throws ExceptionMsg {
        if (value == null) {
            throw new ExceptionMsg(message);
        }
    }

    public static void isBlank(String value, String message) throws ExceptionMsg {
        if (!StringUtils.isBlank(value)) {
            throw new ExceptionMsg(message);
        }
    }
}
