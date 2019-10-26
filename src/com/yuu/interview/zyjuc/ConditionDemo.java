package com.yuu.interview.zyjuc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程之间按顺序调用，实现 A -> B -> C
 * 三个线程启动，要求如下：
 * AA 打印 5 次，BB 打印 10 次，CC 打印 15 次
 * 接着循环 10 轮
 *
 * @author by Yuu
 * @Classname ConditionDemo
 * @Date 2019/10/25 10:58
 * @see com.yuu.interview.zyjuc
 */
public class ConditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareData.print5();
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareData.print10();
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                shareData.print15();
            }
        }, "CC").start();
    }
}

class ShareData {
    /**
     * AA :1 BB :2 CC :3
     */
    private int number = 1;

    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    /**
     * 打印 5 次
     */
    public void print5() {
        lock.lock();
        try {
            // 1. 判断
            while (number != 1) {
                c1.await();
            }
            // 2. 干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }
            // 3. 修改标志位，通知
            number = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 打印 10 次
     */
    public void print10() {
        lock.lock();
        try {
            // 1. 判断
            while (number != 2) {
                c2.await();
            }
            // 2. 干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            // 3. 修改标志位，通知线程
            number = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 打印 15 次
     */
    public void print15() {
        lock.lock();
        try {
            // 1. 判断
            while (number != 3) {
                c3.await();
            }
            // 2. 干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            // 3. 修改标志位，干活
            number = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}