package com.java8.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * com.java8.bean
 * <strong>描述：</strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 *
 * @author: wangjun
 * @date: 2019/1/28.
 */
public class Context {

    private final Map<Class<?>, Object> values = new HashMap<>();

    public <T> void put( Class<T> key, T value ) {
        values.put( key, value );
    }

    public <T> T get( Class<T> key ) {
        return key.cast( values.get( key ) );
    }
}
