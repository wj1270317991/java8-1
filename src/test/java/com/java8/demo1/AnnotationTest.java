package com.java8.demo1;

import com.java8.config.MyConfig;
import com.java8.enums.MyEnum;
import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by wangjun on 2019/1/27.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotationTest {

    /**
     * 工厂bean注解
     */
    @Test
    public void factoryBeanTest(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        Object color = applicationContext.getBean("colorFactoryBean");
        Object colorFactoryBean = applicationContext.getBean("&colorFactoryBean");
        System.out.println("bean 类型："+color.getClass());
        System.out.println("bean 类型："+colorFactoryBean.getClass());

    }
}
