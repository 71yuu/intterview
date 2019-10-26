package com.yuu.interview.juc;

/**
 * @author by Yuu
 * @Classname 多线程与单线程的区别与联系
 * @Date 2019/10/24 11:07
 * @see com.yuu.interview.juc
 */
public class 多线程与单线程的区别与联系 {
    public static void main(String[] args) {
        // 1. 在单核 CPU 中，将 CPU 分成很小的时间片，在每一个适合只能有一个线程在执行，是一种微观上轮流占用 CPU 的机制
        // 2. 多线程存在线程上下文切换，会导致程序执行速度变慢，即采用一个拥有两个线程的进程执行所需要的时间比一个线程的进程执行两次所需要的时间要多一些
        // 多线程不会提高程序的执行速度，反而会降低速度，但是对于用户来说，可以减少用户的响应时间
    }
}
