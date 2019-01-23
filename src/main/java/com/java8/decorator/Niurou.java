package com.java8.decorator;

/**
 * com.java8.decorator
 * <strong>描述：</strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 *
 * @author: wangjun
 * @date: 2019/1/23.
 */
public class Niurou extends NoodleDecorator{


    private Niurou(Noodle noodle) {
        super(noodle);
    }

    public static Niurou instance(Noodle noodle){
        return new Niurou(noodle);
    }

    @Override
    public String descriptin() {
        return noodle.descriptin()+"+牛肉";
    }
}
