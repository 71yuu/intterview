package com.yuu.interview.zyjuc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 现在两个线程，可以操作初始值为零的一个变量，实现一个线程+1，一个线程对变量减一
 * 实现交替 10 轮，变量初始值为零。
 *
 * 1. 线程操作资源类
 * 2. 判断/干活/通知
 * @author by Yuu
 * @Classname ProducerAndConsumer
 * @Date 2019/10/25 10:31
 * @see com.yuu.interview.zyjuc
 */
public class ProducerAndConsumer {
    public static void main(String[] args) {
        Aircondition aircondition = new Aircondition();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    aircondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    aircondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    aircondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    aircondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}

class Aircondition {
    private int number = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        try {
            // 1. 判断
            while (number != 0) {
              condition.await();
            }
            // 2. 干活
            number++;
            System.out.println(Thread.currentThread().getName() + "生产" + number);
            //3. 通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception {
        lock.lock();
        try {
            // 1. 判断
            while (number == 0) {
                condition.await();
            }
            // 2. 干活
            number--;
            System.out.println(Thread.currentThread().getName() + "消费" + number);
            // 3. 通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    /*public synchronized void increment() throws Exception {
        // 1. 判断
        while (number != 0) {
            this.wait();
        }
        // 2. 干活
        number++;
        System.out.println(Thread.currentThread().getName() + "生产" + number);
        // 3. 通知
        this.notifyAll();
    }

    public synchronized void decrement() throws Exception {
        // 1. 判断
        while (number == 0) {
            this.wait();
        }
        // 2. 干活
        number--;
        System.out.println(Thread.currentThread().getName() + "消费" + number);
        // 3. 通知
        this.notifyAll();
    }*/
}