package com.yuu.interview.zyjuc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 1. 故障现象
 *  java.util.ConcurrentModificationException
 *
 * 2. 出现原因
 * 多个线程并发争抢同一个资源类，且没有加锁
 *
 * 3. 解决方案
 * （1）Vector
 * （2）Collections.synchronizedList(new ArrayList<>());
 * （3）new CopyOnWriteArrayList();
 *
 * 4. 优化建议
 * 建议采用 JUC 包下的 CopyOnWriteArrayList()
 *
 * 5. CopyOnWriteArrayList 实现原理
 * 读的时候直接读，写的时候复制原来的数组，扩容，写完后，让数组指向新的数组，
 * 写操作加锁，读操作不加锁，既保证了数据一致性，又保证了并发性
 *
 * @author by Yuu
 * @Classname ListNoSafe
 * @Date 2019/10/25 0:04
 * @see com.yuu.interview.zyjuc
 */
public class ListNoSafe {
    public static void main(String[] args) {
        // List<String> list = new ArrayList<>();
        // List<String> list = new Vector<>();
        // List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}