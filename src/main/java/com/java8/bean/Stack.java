package com.java8.bean;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * com.java8.bean
 * <strong>描述：垃圾回收机制，需要自己手动释放</strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 *
 * @author: wangjun
 * @date: 2019/1/17.
 */
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if(size == 0) {
            throw new EmptyStackException();
        }
//        int a = --size;
//        System.out.println("--size:" + a + ";size:"+size );
        Object o = elements[--size];
        elements[size] = null;
        return o;
    }

    private void ensureCapacity() {
        if(elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    @Override
    public String toString() {
        return "Stack{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }
}
