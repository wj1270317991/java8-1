package com.java8.demo1;

import com.java8.aware.Rainbow;
import com.java8.config.MyConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * com.java8.demo1
 * <strong>描述：</strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 *
 * @author: wangjun
 * @date: 2019/1/23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConditionTest {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (int i = 0;i<beanDefinitionNames.length;i++){
            System.out.println(beanDefinitionNames[i]);
        }
    }


    @Test
    public void test2(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Rainbow.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        System.out.println(beanDefinitionNames);
    }

}
