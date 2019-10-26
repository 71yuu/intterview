package com.yuu.interview.juc;

/**
 * @author by Yuu
 * @Classname 线程与进程的区别
 * @Date 2019/10/24 13:55
 * @see com.yuu.interview.juc
 */
public class 线程与进程的区别 {
    public static void main(String[] args) {
        // 1. 进程是一个执行中的程序，是系统进行资源分配和调度的一个独立单位
        // 2. 线程是进程的一个实体，一个进程中拥有多个线程，线程之间共享地址空间和其他资源（所以通信和同步等操作线程比进程更加容易）
        // 3. 线程上下文的切换比进程上下文切换要快很多
        // （1）进程切换时，涉及到当前进程的 CPU 环境的保存和新被调度运行进程的 CPU 环境的设置
        // （2）线程切换仅需要保存和设置少量的寄存器内容，不涉及存储管理方面的操作
    }
}
