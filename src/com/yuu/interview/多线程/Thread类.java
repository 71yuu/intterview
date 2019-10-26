package com.yuu.interview.多线程;

import java.util.concurrent.TimeUnit;

/**
 * @author by Yuu
 * @Classname Thread类
 * @Date 2019/10/24 16:52
 * @see com.yuu.interview.多线程
 */
public class Thread类 {
    public static void main(String[] args) throws InterruptedException {
        /**
         * java.lang.Thread 类
         * 构造方法：
         * public Thread() :分配一个新的线程对象。
         * public Thread(String name) :分配一个指定名字的新的线程对象。
         * public Thread(Runnable target) :分配一个带有指定目标新的线程对象。
         * public Thread(Runnable target,String name) :分配一个带有指定目标新的线程对象并指定名字。
         * 常用方法：
         * public String getName() :获取当前线程名称。
         * public void start() :导致此线程开始执行; Java虚拟机调用此线程的run方法。
         * public void run() :此线程要执行的任务在此处定义代码。
         * public static void sleep(long millis) :使当前正在执行的线程以指定的毫秒数暂停（暂时停止执行）。
         * public static Thread currentThread() :返回对当前正在执行的线程对象的引用。
         */

        new Thread();

        new Thread("23");

        new Thread(() -> {

        });

        new Thread(() -> {

        }, "123");

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println("当前线程" + Thread.currentThread().getName());
            }, i + "").start();
        }

        Thread.sleep(3000);
        System.out.println("hello");

    }
}
