package com.yuu.interview.juc;

/**
 * @author by Yuu
 * @Classname ThreadLocal
 * @Date 2019/10/24 15:06
 * @see com.yuu.interview.juc
 */
public class ThreadLocal关键字 {
    public static void main(String[] args) {
        /**
         * ThreadLocal 线程局部变量
         * 当使用 ThreadLocal 维护变量时，其为每个使用该变量的线程提供独立的变量
         * 副本，所以每一个线程都可以独立的改变自己的副本，而不会影响其他线程对应
         * 的副本。
         *
         * ThreadLocal 内部实现机制
         * 1. 每个线程内部都会维护一个类似 HashMap 的对象，成为 ThreadLocalMap,里边会包含
         * 若干了 Entry(K-V键值对），相应的线程被成为这些 Entry 的宿主线程
         * 2. Entry 的 Key 时一个 ThreadLocal 实例，Value 是一个线程特有对象。Entry
         * 的作用即是：为其属主线程建立起一个 ThreadLocal 实例与一个线程特有对象之间的对应关系
         * 3. Entry 对 Key 的引用是弱引用：Entry 对 Value 的引用是强引用
         */
    }
}
