package com.yuu.interview.juc;

/**
 * @author by Yuu
 * @Classname volatile关键字
 * @Date 2019/10/24 14:59
 * @see com.yuu.interview.juc
 */
public class volatile关键字 {
    public static void main(String[] args) {
        // 该关键字可以保可见性不保证原子性
        // 功能：
        // 主内存和工作内存，直接与主内存产生交互，进行读写操作，保证可见性
        // 禁止 JVM 进行指令重排序
    }
}
