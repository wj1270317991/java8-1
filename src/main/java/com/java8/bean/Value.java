package com.java8.bean;

import java.math.BigInteger;

/**
 * com.java8.bean
 * <strong>描述：</strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 *
 * @author: wangjun
 * @date: 2019/1/23.
 */
public class Value {
    final int a = 1;
    final int b;

    public Value(int b) {
        this.b = b;
    }

    public void say(){
        System.out.println("a:"+a+",b:"+b);
        BigInteger a= new BigInteger("fdfdfdsfsddfsfds");
        a.flipBit(0);
    }
}
