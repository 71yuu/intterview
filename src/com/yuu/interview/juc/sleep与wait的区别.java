package com.yuu.interview.juc;

/**
 * @author by Yuu
 * @Classname sleep与wait的区别
 * @Date 2019/10/24 14:40
 * @see com.yuu.interview.juc
 */
public class sleep与wait的区别 {
    public static void main(String[] args) {
        // 1. sleep 方法
        // 是 Thread 类的静态方法，当前线程将睡眠 n 毫秒，线程进入阻塞状态。
        // 当睡眠时间到了，会解除阻塞，进行可运行状态，等待 CPU 的到来。睡眠不是放锁（如果有的话）
        // 2. wait 方法
        // 是 Object 的方法，必须与 synchronized 关键字一起使用，线程进入阻塞状态，当 notify 或者 notifyAll 被调用后，会解除阻塞。
        // 只有重新占用互斥锁之后才会进入可运行状态。睡眠时，释放互斥锁。
    }
}
