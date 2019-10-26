package com.yuu.interview.collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author by Yuu
 * @Classname ConcurrentHashMap的具体实现你知道吗
 * @Date 2019/10/24 9:21
 * @see com.yuu.interview.collection
 */
public class ConcurrentHashMap的具体实现你知道吗 {
    public static void main(String[] args) {
        // 1. 该类包含两个静态内部类 HashEntry 和 Segment, HashEntry 用来封装映射的键值对，Segment 用来充当锁的角色
        // 2. Segment 是一种可重入的 ReentrantLock，每个 Segment 守护一个 HashEntry 数组里得元素，当对 HashEntry 数组得数据进行修改时，必须首先获得对应得 Segment 锁。
    }
}
