package com.java8.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * com.java8.demo1
 * <strong>描述：</strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 * 测试Jedis在多实例下的事务的情况，jedis.watch可以保证同步执行
 * @author: wangjun
 * @date: 2019/1/9.
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class JedisPoolTest {

    private String key = "information";

    @Test
    public void InitData(){
        //初始化数据
        String information = this.getJedis().getResource().set(key, "100");
    }



    @Test
    public void test1Multi(){
        Jedis jedis = this.getJedis().getResource();
        jedis.watch(key);
        Transaction tran = jedis.multi(); // 开启事务
        tran.incrBy(key, -10); // 商品数量-100
        List<Object> exec = tran.exec();
        System.out.println(exec);
    }

    @Test
    public void test2Multi(){
        Jedis jedis = this.getJedis().getResource();
        jedis.watch(key);
        Transaction tran = jedis.multi(); // 开启事务
        tran.incrBy(key, -20); // 商品数量-100
        List<Object> exec = tran.exec();
        System.out.println(exec);
    }







    private JedisPool getJedis(){
        // 建立连接池配置参数
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(100);
        // 设置最大阻塞时间，记住是毫秒数milliseconds
        config.setMaxWaitMillis(1000);
        // 设置空间连接
        config.setMaxIdle(10);

        JedisPool jedisPool = new JedisPool(config,"127.0.0.1", 6379, 2000, null, 4);

        return jedisPool;
    }
}
