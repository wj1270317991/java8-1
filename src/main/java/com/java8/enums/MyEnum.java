package com.java8.enums;

/**
 * Created by wangjun on 2019/2/17.
 */
public enum MyEnum {
    SUCCESS(200,"sucess"),
    FAIL(500,"fail");

    private int code;

    private String msg;

    MyEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
