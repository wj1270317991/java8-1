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
public abstract class NoodleDecorator implements Noodle{

    Noodle noodle;

    public NoodleDecorator(Noodle noodle) {
        this.noodle = noodle;
    }

    @Override
    public abstract String descriptin();

}
