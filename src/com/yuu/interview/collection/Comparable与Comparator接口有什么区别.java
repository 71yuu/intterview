package com.yuu.interview.collection;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author by Yuu
 * @Classname Comparable与Comparator接口有什么区别
 * @Date 2019/10/24 10:00
 * @see com.yuu.interview.collection
 */
public class Comparable与Comparator接口有什么区别 {
    public static void main(String[] args) {
        // 1. 存在包
        // Comparable 位于 java.lang 包下，Comparator 位于 java.util 包下
        // 前者简单，但是如果需要重新自定义比较类型，需要修改源代码
        // 后者不需要修改源代码，自定义一个比较器，实现自定义的比较方法

       /* TreeSet<Person> people = new TreeSet<>();
        people.add(new Person(1, "Yuu"));
        people.add(new Person(1, "Yuu"));
        System.out.println(people.size());*/

        /*TreeSet<Person> people = new TreeSet<>(new myc());
        people.add(new Person(1, "yUU"));
        people.add(new Person(1, "yuu"));
        System.out.println(people.size());*/
    }
}

class Person implements Comparable<Person> {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        if (this.age > o.getAge()) {
            return 1;
        } else if (this.age == o.getAge()) {
            return 0;
        } else {
            return -1;
        }
    }
}

class myc implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getAge() > o2.getAge()) {
            return 1;
        } else if (o1.getAge() == o2.getAge()) {
            return 0;
        } else {
            return -1;
        }
    }
}