package com.java8.demo1;

import com.java8.demo1.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

/**
 * com.java8.demo1
 * <strong>描述：</strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 *
 * @author: wangjun
 * @date: 2018/11/12.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class Lambda {

    @Test
    public void parallel() {
        Instant instant = Instant.now();

        Long reduce = Stream.iterate(1L, i -> i + 1).limit(100000L).parallel().reduce(0L,Long::sum);

        Instant instant1 = Instant.now();

        Long reduce2 = Stream.iterate(1L, i -> i + 1).limit(100000L).reduce(0L,Long::sum);

        Instant instant2 = Instant.now();

        System.out.println(Duration.between(instant,instant1).getNano());
        System.out.println(Duration.between(instant1,instant2).getNano());

    }


    @Test
    public void HashMap(){
//        Map map = new HashMap();
//
//        Map map1 = new ConcurrentHashMap();
        Person person = null;
        if (person != null && person.name !=null){
            System.out.println("person is null");
        }
    }
}
