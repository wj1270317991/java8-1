package com.java8.demo1.thread;

/**
 * com.java8.demo1.thread
 * <strong>描述：</strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 *
 * @author: wangjun
 * @date: 2018/10/15.
 */

public class TestRunnable implements Runnable {

   int ticket = 100;

    @Override
    public void run() {
        while (true){
            if (ticket>0){
                System.out.println(Thread.currentThread().getName()+":"+ticket--);
            }
        }
    }
}
