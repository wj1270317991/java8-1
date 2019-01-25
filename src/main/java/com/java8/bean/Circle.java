package com.java8.bean;

import java.util.Objects;

/**
 * com.java8.bean
 * <strong>描述：</strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 *
 * @author: wangjun
 * @date: 2019/1/24.
 */
public class Circle implements Figure{

    final double radius;

    static Circle circle = null;

    private Circle(double radius) {
        this.radius = radius;
    }

    public static Circle instance(double radius){
        if (circle == null){
            circle = new Circle(radius);
        }
        return circle;
    }

    @Override
    public double area() {
        return Math.PI * radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}
