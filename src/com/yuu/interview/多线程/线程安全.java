package com.yuu.interview.多线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author by Yuu
 * @Classname 线程安全
 * @Date 2019/10/24 17:23
 * @see com.yuu.interview.多线程
 */
public class 线程安全 {
    public static void main(String[] args) {
        /**
         * 当我们使用多个线程访问同一资源的时候，且多个线程中对资源有写的操作，就容易出现线程安全问题。
         * 要解决上述多线程并发访问一个资源的安全性问题:也就是解决重复票与不存在票问题，Java中提供了同步机制 (synchronized)来解决。
         */

        /**
         *  窗口1线程进入操作的时候，窗口2和窗口3线程只能在外等着，窗口1操作结束，
         *  窗口1和窗口2和窗口3才有机会进入代码去执行。也就是说在某个线程修改共享资源的时候，
         *  其他线程不能修改该资源，等待修改完毕同步之后，才能去抢夺CPU 资源，完成对应的操作，
         *  保证了数据的同步性，解决了线程不安全的现象
         */

        /**
         * 为了保证每个线程都能正常执行原子操作,Java引入了线程同步机制。
         * 那么怎么去使用呢？有三种方式完成同步操作：
         * 1. 同步代码块。
         * 2. 同步方法。
         * 3. 锁机制。
         */

        /**
         * 同步代码块： synchronized 关键字可以用于方法中的某个区块中，
         * 表示只对这个区块的资源实行互斥访问。
         * synchronized(同步锁){
         *      需要同步操作的代码
         * }
         *
         * 同步锁:
         * 对象的同步锁只是一个概念,可以想象为在对象上标记了一个锁.
         * 1. 锁对象 可以是任意类型。
         * 2. 多个线程对象  要使用同一把锁。
         * 注意:在任何时候,最多允许一个线程拥有同步锁,谁拿到锁就进入代码块,
         * 其他的线程只能在外等着 (BLOCKED)。
         *
         * 同步方法:使用synchronized修饰的方法,就叫做同步方法,
         * 保证A线程执行该方法的时候,其他线程只能在方法外 等着。
         * 对于同步方法，同步锁锁谁?
         *   对于非static方法,同步锁就是this。
         *   对于 static方法,我们使用当前方法所在类的字节码对象(类名.class)。
         *
         *  Lock 锁
         * java.util.concurrent.locks.Lock 机制提供了比 synchronized 代码块和 synchronized 方法更广泛的锁定操作,
         * 同步代码块/同步方法具有的功能Lock都有,除此之外更强大,更体现面向对象。
         * Lock锁也称同步锁，加锁与释放锁方法化了，如下：
         * public void lock() :加同步锁。
         * public void unlock() :释放同步锁。
         */

        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket, "售票员1");
        Thread thread2 = new Thread(ticket, "售票员2");
        Thread thread3 = new Thread(ticket, "售票员3");
        thread1.start();
        thread2.start();
        thread3.start();


    }
}

class Ticket implements Runnable {
    private int ticket = 100;

    /*Object lock = new Object();*/

    Lock lock = new ReentrantLock();

    /**
     * 执行卖票操作
     */
    @Override
    public void run() {
        while (true) {
            /*
            // 同步代码块
            synchronized (lock) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket-- + "张票");
                }
            }*/

           /* // 同步方法
           method();*/

            lock.lock();
            if (ticket > 0) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket-- + "张票");
            }
            lock.unlock();
        }
    }

    /**
     * 卖票的方法，同步方法
     */
    public synchronized void method() {
        if (ticket > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket-- + "票");
        }
    }
}