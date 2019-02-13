package com.java8.config;

import com.java8.annotaion.MyImportSelector;
import com.java8.condition.LinuxCondition;
import com.java8.demo1.model.Person;
import org.springframework.context.annotation.*;

/**
 * com.java8.config
 * <strong>描述：</strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 *
 * @author: wangjun
 * @date: 2019/1/23.
 */

@Configuration
@ComponentScan({"com.java8.aware","com.java8.beanpostprocessor"})
@Import({MyImportSelector.class})
public class MyConfig {

//    @Conditional(LinuxCondition.class)
//    @Bean
//    public Person person(){
//        return new Person("bill",62);
//    }
//
//
//
//    @Bean
//    public Person person2(){
//        return new Person("bill",62);
//    }
}
