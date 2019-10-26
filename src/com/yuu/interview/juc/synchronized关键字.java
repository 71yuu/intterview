package com.yuu.interview.juc;

/**
 * @author by Yuu
 * @Classname synchronized关键字
 * @Date 2019/10/24 14:48
 * @see com.yuu.interview.juc
 */
public class synchronized关键字 {
    public static void main(String[] args) {
        /**
         * synchronized 的底层实现
         * 1. 进入时，执行 monitorenter，将计数器 +1，释放锁 monitorexit 时，计数器 -1
         * 2. 当一个线程判断到计数器为 0 时，则当前锁空闲，可以占用，反之，当前线程进入等待状态
         */

        /**
         * monitor 机制
         * Synchronized 是在加锁，加对象锁。对象锁是一种重量锁（monitor),synchronized
         * 的锁机制会根据线程竞争情况在运行时会有偏向锁（单一线程）、轻量锁（多个线程访问
         * synchronized 区域）、对象锁（重量锁，多个线程存在竞争的情况）、自旋锁等。该
         * 关键字是一个几种锁的封装。
         */

    }
}
