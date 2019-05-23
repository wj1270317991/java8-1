package com.java8.demo1;


import com.java8.bean.Thread1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadTest {

    @Test
    public void threadTest1(){
        Thread1 thread1 = new Thread1();
        thread1.start();
    }

    @Test
    public void tt(){
        int a  = 10;
        for (int i = 0;i < a ;i++){
            int j = a - i;
            for (int k=0;k<j;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    @Test
    public void test01(){ //3628800
        //求值 n!
        long current = System.currentTimeMillis();
        System.out.println(getFactorial(100));
        System.out.println("话费时间为："+(System.currentTimeMillis() - current)+"毫秒");
    }

    private static long getFactorial2(long n){

        long mul = 1;
        for (int i = 1;i<=n;i++){
            mul *= i;
        }
        System.out.println();
        return mul;
    }

    private static long getFactorial(long n){
        if (n == 1 || n == 2){
            return n;
        }
        if (n < 1){
            return 0;
        }
        return n * getFactorial(n -1);
    }

    @Test
    public void test02(){
        int [] list= new int[100];
        for (int o=0;o<100;o++){
            int v = (int)(Math.random() * 100);
            list[o] = v;
        }
        int tmp;
//        for (int i=0;i<list.length;i++){
//            for (int j=i+1;j<list.length;j++){
//                if (list[i]<list[j]){
//                    tmp = list[i];
//                    list[i] = list[j];
//                    list[j] = tmp;
//                }
//            }
//        }

        for(int i=1; i<list.length; i++) {
            for(int j=0; j<list.length-i; j++) {
                if(list[j] < list[j+1]) {
                    tmp = list[j];
                    list[j]=list[j+1];
                    list[j+1]=tmp;
                }
            }
        }

        for (int k=0;k<list.length;k++) {
            System.out.println(list[k]);
        }
    }

    //1、2、2、3、4、5这六个数字，用java写一个main函数，打印出所有不同的排列， 如：512234、412345等.要求：”4”不能在第三位，”3”与”5”不能相连。
    @Test
    public void test03(){
        int count=0;
        for (int i = 122345; i <=543221; i++) {
            if (isValidNumber(String.valueOf(i))) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println(count);
    }


    private static String[] mustExistNumber = new String[] { "1", "2", "2", "3", "4", "5" };

    private static boolean isValidNumber(String str) {
        // 检查是否包含12345这五个数，不包含返回false
        for (String number : mustExistNumber) {
            if (str.indexOf(number) < 0)
                return false;
        }
        // 检查是否有两个2，只有一个返回false
        if (str.lastIndexOf("2") == str.indexOf("2")) {
            return false;
        }
        // 检查4在不在第三位，是返回false
        if (str.charAt(2) == '4') {
            return false;
        }
        // 检查是否存在35在一起，有返回false
        if (str.indexOf("35") >= 0 || str.indexOf("53") >= 0) {
            return false;
        }
        return true;
    }


    @Test
    public void yanhuisanjiao(){
        int rows = 10;

        for(int i =0;i<rows;i++) {
            int number = 1;
            //打印空格字符串
            System.out.format("%"+(rows-i)*2+"s","_");
            for(int j=0;j<=i;j++) {
                System.out.format("%4d",number);
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

    @Test
    public void test04(){
        System.out.format("%4d",5);
        System.out.println();
    }


    @Test
    public void test05(){
        play(10,7);
    }

    private static boolean same(int[] person,int l,int n) {
        for (int i=0; i<l; i++) {
            if(person[i] == n) {
                return true;
            }
        }
        return false;
    }

    public static void play(int playerNum, int step ) {
        int[] person = new int[playerNum];
        int counter = 1;
        while(true) {
            if(counter > playerNum*step) {
                break;
            }
            for(int i=1;i<=playerNum;i++) {
                while(true) {
                    if(same(person,playerNum,i) == false) {
                        break;
                    }else {
                        i = i+1;
                    }
                }
                if(i > playerNum) {
                    break;
                }
                if(counter%step == 0) {
                    System.out.println(i+" ");
                    person[counter/step -1] = i;
                }
                counter +=1;
            }
        }
        System.out.println();
    }


}
