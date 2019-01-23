package com.java8.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Transaction;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * com.java8.demo1
 * <strong>描述：redis秒杀测试 </strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 *
 * ExecutorService 解释
 * https://blog.csdn.net/zaozi/article/details/38854561
 *
 * @author: wangjun
 * @date: 2019/1/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SecondKillTest {


    @Test
    public void getResult() {
        Jedis jedis = JedisPoolUtil.getJedis();
        String goodsResult = jedis.get("goodsResult:user102");
        System.out.println(goodsResult);
    }




    @Test
    public void test() throws IOException, InterruptedException {
        /** 初始化商品 */
        initGoods();

        /** 1000线程抢购100个商品 */
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        CountDownLatch count = new CountDownLatch(10000);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new SecondKillHandlder("user" + i));
            count.countDown();
        }
        //询问是否结束线程
        executorService.shutdown();
        count.await();
        long time = System.currentTimeMillis() - startTime;
        System.out.println("共耗时：" + time + "毫秒");
        // JedisPoolUtil.close();
        System.in.read();
    }


    /**
     * 对多容器和多并发的问题的 jedis.watch 可以保证 同步执行
     *
     */

    /** 秒杀处理线程 */
    private static class SecondKillHandlder implements Runnable {
        String goodsKey = "goods:iphone8"; // 监视的key 当前秒杀商品的数量
        Jedis jedis;
        String userName;

        public SecondKillHandlder(String userName) {
            this.userName = userName;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    jedis = JedisPoolUtil.getJedis();
                    // watch 监视一个key，当事务执行之前这个key发生了改变，事务会被打断
                    jedis.watch(goodsKey);
                    int currentGoodsCount = Integer.parseInt(jedis.get(goodsKey)); // 当前剩余商品数量
                    if (currentGoodsCount <= 0) {
                        System.out.println("商品已抢完，" + userName + "---> 抢购失败 XXX");
                        break;
                    }

                    Transaction tran = jedis.multi(); // 开启事务
                    tran.incrBy(goodsKey, -1); // 商品数量-1
                    List<Object> exec = tran.exec(); // 执行事务
                    if (CollectionUtils.isEmpty(exec)) {
                        System.out.println(userName + "---> 抢购失败，继续抢购");
                        Thread.sleep(1);
                    } else {
                        exec.forEach(
                                succ -> {
                                    String succStr =
                                            userName
                                                    + "===========================> 抢购到第【"
                                                    + ((10 - currentGoodsCount) + 1)
                                                    + "】份商品，该商品剩余："
                                                    + succ.toString();
                                    System.out.println(succStr);
                                    jedis.set("goodsResult:" + userName, succStr); // 业务代码，处理抢购成功
                                });
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (jedis != null) {
                        jedis.unwatch();
                        JedisPoolUtil.returnRes(jedis);
                    }
                }
            }
        }
    }





    /** 初始化商品数量 */
    private void initGoods() {
        Jedis jedis = JedisPoolUtil.getJedis();
        jedis.set("goods:iphone8", "10"); // 设置100个商品
        JedisPoolUtil.returnRes(jedis);
    }

    private static class JedisPoolUtil {

        private static JedisPool pool;

        private static void createJedisPool() {
            // 建立连接池配置参数
            JedisPoolConfig config = new JedisPoolConfig();
            // 设置最大连接数
            config.setMaxTotal(100);
            // 设置最大阻塞时间，记住是毫秒数milliseconds
            config.setMaxWaitMillis(1000);
            // 设置空间连接
            config.setMaxIdle(10);
            // 创建连接池
            pool = new JedisPool(config, "127.0.0.1", 6379, 2000, null, 3);
        }

        /** 在多线程环境同步初始化 */
        private static synchronized void poolInit() {
            if (pool == null) createJedisPool();
        }

        /**
         * 获取一个jedis 对象
         *
         * @return
         */
        public static Jedis getJedis() {

            if (pool == null) poolInit();
            return pool.getResource();
        }

        /**
         * 归还一个连接
         *
         * @param jedis
         */
        public static void returnRes(Jedis jedis) {
            jedis.close();
        }

        public static void close() {
            pool.close();
        }
    }
}






