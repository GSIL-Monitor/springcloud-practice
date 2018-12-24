package com.dianping.hui.exception;

import com.netflix.hystrix.exception.HystrixBadRequestException;

/**
 * @author: lanxinyu@meituan.com  2018-11-16 下午5:29
 * @Description: 不回退的异常
 */
public class NotCricuitException extends HystrixBadRequestException {

    public NotCricuitException(String message) {
        super(message);
    }

    public NotCricuitException(String message, Throwable cause) {
        super(message, cause);
    }
}
