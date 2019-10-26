package com.yuu.interview.collection;

/**
 * @author by Yuu
 * @Classname ConcurrentHashMap与Hashtable的区别
 * @Date 2019/10/24 9:17
 * @see com.yuu.interview.collection
 */
public class ConcurrentHashMap与Hashtable的区别 {
    public static void main(String[] args) {
        // ConcurrentHashMap 结合了 HashMap 与 Hashtable 二者的优势，HashMap 没有考虑同步，Hashtable 考虑了同步，但是 Hashtable 每次同步执行的时候都要锁住整个结构。
        // ConcurrentHashMap 锁是稍微细粒度的。ConcurrentHashMap 将 Hash 表分为 16 个桶（默认值），当执行 get/put/put 等常用操作的时候只锁当前需要用的桶。
    }
}
