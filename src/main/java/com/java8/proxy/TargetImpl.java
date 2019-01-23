package com.java8.proxy;

/**
 * com.java8.proxy
 * <strong>描述：</strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 *
 * @author: wangjun
 * @date: 2018/11/7.
 */
public class TargetImpl implements Target {

    @Override
    public int add(int a,int b) {
        return a + b;
    }

    @Override
    public int sub(int a,int b) {
        return a - b;
    }

    @Override
    public int mul(int a,int b) {
        return a * b;
    }

    @Override
    public int div(int a,int b) {
        return a/b;
    }
}
