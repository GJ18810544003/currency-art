package com.twilight.currency.art.exception;

/**
 * @Description:
 * @Author: guojun
 * @Date: 2020/6/15
 */
public class Test {

    public static void main(String[] args) {

        Integer i = null;
        try {
            ResponseEnum.BAD_LICENCE_TYPE.assertNotNull(i);
        }catch (Exception e) {
            System.out.println(e);
        }


    }
}
