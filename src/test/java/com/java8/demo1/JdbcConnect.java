package com.java8.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


/**
 * com.java8.demo1
 * <strong>描述：</strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 *
 * @author: wangjun
 * @date: 2018/11/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcConnect {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;


    @Test
    public void demo1() throws ExecutionException, InterruptedException {
//        String sql = "select * from good_infos";
//        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<String>> list = new ArrayList<>();
        List<Callable<String>> ll = new ArrayList<>();
        for (int i = 0; i< 10 ; i++){

//            Callable<String> callable = new Callable<String>() {
//                @Override
//                public String call() throws Exception {
//                    return "开始结束" ;
//                }
//            };
            ll.add(()->"线程："+Thread.currentThread().getName());

            //list.add(executorService.submit(callable));
        }
        List<Future<String>> list1 = executorService.invokeAll(ll);
        for (Future<String> item : list1){
            String s = item.get();
            System.out.println(s);
        }



    }


    @Test
    public void completableFuture(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(()->{

        },executorService);

    }

}
