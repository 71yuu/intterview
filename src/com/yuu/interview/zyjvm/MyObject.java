package com.yuu.interview.zyjvm;

/**
 * @author by Yuu
 * @Classname MyObject
 * @Date 2019/10/25 17:06
 * @see com.yuu.interview.zyjvm
 */
public class MyObject {

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(o.getClass().getClassLoader());

        MyObject myObject = new MyObject();
        System.out.println(myObject.getClass().getClassLoader().getParent().getParent());
        System.out.println(myObject.getClass().getClassLoader().getParent());
        System.out.println(myObject.getClass().getClassLoader());
    }
}
