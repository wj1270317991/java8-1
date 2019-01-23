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
public class PersonBuilder {
    private String name;
    private int age;
    private boolean sex;

    private PersonBuilder(Builder builder) {
        name = builder.name;
        age = builder.age;
        sex = builder.sex;
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

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public static class Builder{
        private String name;
        private int age;
        private boolean sex;

        public Builder name(String n){
            name = n;
            return this;
        }

        public Builder age(int a) {
            age = a;
            return this;
        }

        public Builder sex(boolean s) {
            sex = s;
            return this;
        }

        public PersonBuilder build() {
            return new PersonBuilder(this);
        }

    }

    @Override
    public String toString() {
        return "PersonBuilder{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
