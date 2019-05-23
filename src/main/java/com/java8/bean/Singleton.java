package com.java8.bean;


/*懒汉*/
public class Singleton {
    private static volatile Singleton singleton = null;


    public Singleton() {
    }

    public static Singleton getSingleton(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
