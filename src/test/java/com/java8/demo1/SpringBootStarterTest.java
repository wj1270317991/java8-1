package com.java8.demo1;


import com.spring.starter.springbootstartdemo1.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootStarterTest {

    @Autowired
    HelloService helloService;

    @Test
    public void test1(){
        String s = helloService.haloHello();
        System.out.println(s);
    }

}
