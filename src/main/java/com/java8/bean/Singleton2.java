package com.java8.bean;


/*恶汉*/
public class Singleton2 {
    private static  Singleton2 singleton = new Singleton2();

    public Singleton2() {
    }

    public static Singleton2 getSingleton() {
        return singleton;
    }



}
