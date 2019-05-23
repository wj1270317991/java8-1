package com.java8.demo1;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IteratorTest {


    @Test
    public void ListIteratorTest(){
        List<String> staff = new LinkedList<>();
        staff.add("zhuwei");
        staff.add("xuezhangbin");
        staff.add("taozhiwei");
        ListIterator<String> iter = staff.listIterator();
        String first = iter.next();
        //删除zhuwei
        iter.remove();

        //把zhuwei改为simei
        //iter.set("simei");
        System.out.println("first:"+first);


        LinkedList<Object> objects = new LinkedList<>();


    }
}
