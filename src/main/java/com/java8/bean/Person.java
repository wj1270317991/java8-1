package com.java8.bean;

/**
 * com.java8.bean
 * <strong>描述：</strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 *
 * @author: wangjun
 * @date: 2019/1/15.
 */
public class Person implements Cloneable{

    private String name;

    private int age;

    private static Person single = null;

    private Person() {

    }

    public static Person getIntance(){
        if (single == null){

            synchronized (Person.class){
                if (single == null){
                    single = new Person();
                }
            }
        }
        return single;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
