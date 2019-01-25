package com.java8.demo1;

import com.java8.bean.*;
import com.java8.decorator.Jidan;
import com.java8.decorator.JidanNoodle;
import com.java8.decorator.Noodle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * com.java8.demo1
 * <strong>描述：</strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 *
 * @author: wangjun
 * @date: 2019/1/15.
 *
 * https://www.jianshu.com/p/6f3ee90ab7d3
 *
 * https://blog.csdn.net/bboyfeiyu/article/details/24851847
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EffectiveJavaTest {


    @Test
    public void instance(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int a=0; a<100 ;a++) {
            executorService.submit(()->{
                int intFlag = (int)(Math.random() * 1000000);
                Person intance = Person.getIntance();
                intance.setName("zhangsan" + intFlag);
                intance.setAge(intFlag);
                System.out.println(intance);
            });
        }
        boolean shutdown = executorService.isShutdown();
    }


    @Test
    public void builder(){
        PersonBuilder stephenHe = new PersonBuilder.Builder().age(20).sex(true).build();
        System.out.println(stephenHe.getName());
    }


    /**
     * 内存释放
     */
    @Test
    public void stack(){

        Object object1 = new Object();
        Object object2 = object1;
        Object object3 = object2;
        object1 = null;
        System.out.println(object2);

//        Stack stack = new Stack();
//        stack.push(1);
//        stack.push(2);
//        System.out.println(stack.pop());
//        System.out.println(stack);
    }

    @Test
    public void equalsTest() throws MalformedURLException {
        String a = "abc";
        String b = new String("abc");
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        Person p = Person.getIntance();
    }


    @Test
    public void finalTest(){
        Value value = new Value(23);
        value.say();
    }


    /**
     * 装饰者模式，但是个人感觉就是依赖注入，
     */
    @Test
    public void decoratorTest(){

        Jidan instance = Jidan.instance(new JidanNoodle());
        System.out.println(instance.descriptin());
    }


    /**
     * 思想是为了类层次的扩展，思想没有问题
     * 这是一个错误的案例，静态变量只初始化了一次
     */
    @Test
    public void classAndInterfaceTest1(){
        double area = Circle.instance(1.00).area();
        System.out.println(area);
        Circle instance1 = Circle.instance(3.00);
        Circle instance2 = Circle.instance(4.00);
        System.out.println(instance1 == instance2);
        System.out.println(instance1.area());
        System.out.println(instance2.area());
    }


    @Test
    public void classAndInterfaceTest2(){
        return;
    }









}
