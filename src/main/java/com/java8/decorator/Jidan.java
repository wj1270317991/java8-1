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
public class Jidan extends NoodleDecorator{

    private Jidan(Noodle noodle) {
        super(noodle);
    }

    public static Jidan instance(Noodle noodle){
       return new Jidan(noodle);
    }

    @Override
    public String descriptin() {
        return noodle.descriptin() +"+鸡蛋";
    }
}
