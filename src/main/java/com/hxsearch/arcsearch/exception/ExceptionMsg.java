package com.hxsearch.arcsearch.exception;

/**
 * 功能描述：
 *
 * @Author: ddw
 * @Date: 2021/8/6 15:38
 */
public class ExceptionMsg extends  Exception {
    public ExceptionMsg(Throwable t) {
        this(godown(t).getMessage());
    }

    public ExceptionMsg(String msg) {
        super(msg);
    }

    public ExceptionMsg(String msg, Throwable cause) {
        super(msg, cause);
    }

    private static Throwable godown(Throwable throwable) {
        if (throwable.getMessage() != null && !"".equals(throwable.getMessage())) {
            return new ExceptionMsg(throwable.getMessage());
        }
        while (throwable.getCause() != null) {
            throwable = throwable.getCause();
        }
        return throwable;
    }
}
