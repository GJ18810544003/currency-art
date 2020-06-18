package com.twilight.currency.art.exception;

/**
 * @Description:
 * @Author: guojun
 * @Date: 2020/6/15
 */
public class BaseException extends RuntimeException{

    public BaseException(IResponseEnum responseEnum, Object[] args, String message) {
        System.out.println("BaseException :" + message);
    }

    public BaseException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        System.out.println("BaseException :" + message);
    }
}
