package com.yuu.interview.多线程;

/**
 * @author by Yuu
 * @Classname 多线程原理
 * @Date 2019/10/24 16:15
 * @see com.yuu.interview.多线程
 */
public class 多线程原理 {
    public static void main(String[] args) {
        System.out.println("这里是 main 线程");
        MyThread myThread = new MyThread("测试线程");
        myThread.start();
        for (int i = 0; i < 2000; i++) {
            System.out.println("Yuu" + i);
        }

        /**
         * 程序启动运行main时候，java虚拟机启动一个进程，
         * 主线程main在main()调用时候被创建。
         * 随着调用 myThread的对象的 start方法，另外一个新的线程也启动了，
         * 这样，整个应用就在多线程下运行。
         */

        /**
         * 多线程执行时，到底在内存中是如何运行的呢？
         * 多线程执行时，在栈内存中，其实每一个执行线程都有一片自己所属的栈内存空间。
         * 进行方法的压栈和弹栈。
         */
    }
}

class MyThread extends Thread {

    /**
     * 利用继承中的特点
     *  将线程名称传递，进行设置
     *
     * @param name 线程名称
     */
    public MyThread(String name) {
        super(name);
    }

    /**
     * 重写 run 方法
     */
    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            // getName() 方法，来自 Thread 类
            System.out.println(getName() + i);
        }
    }
}