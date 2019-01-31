package com.java8.factorybean;

import com.java8.bean.Color;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;

/**
 * Created by wangjun on 2019/1/27.
 */

public class ColorFactoryBean implements FactoryBean<Color> {

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Nullable
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }
}
