package com.yuu.interview.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author by Yuu
 * @Classname Java集合的快速失败机制failfast
 * @Date 2019/10/24 10:25
 * @see com.yuu.interview.collection
 */
public class Java集合的快速失败机制failfast {
    public static void main(String[] args) {
        // fail-fast 是 Java 的一种错误检测机制，当多个线程对集合进行结构上的改变的操作时
        // 有可能会产生 fail-fast 机制
        // 例如一个线程正在遍历集合，另一个线程在修改集合，这时就会抛出 ConcurrentHashMap 异常

        // 迭代器在遍历时直接访问集合中的内容，并且在遍历过程中使用一个 modCount 变量。
        // 集合在遍历期间如果内容发生改变，就会改变 modCount 的值。每当迭代器使用 hasNext()/next() 遍历下一个元素之前，都会检测 modCount 变量是否为 expectemodCount 值，是的话就返回遍历，否者抛出异常，终止遍历

        // 解决方法
        // （1）在所有涉及到改变 modCount 改变的方法，全部加上 synchronized
        // （2）使用 CopyOnWriteArrayList 代替 ArrayList

        List<Object> list = new CopyOnWriteArrayList<>();
        list.add("213");
        list.add("gfga");

        new Thread(() -> {
            for (int i = 0; i < 1000000000; i++) {
                list.forEach(e -> System.out.println(e));
            }
        }, "").start();

        new Thread(() -> {
            for (int i = 0; i < 100000000; i++) {
                list.add(i);
            }
        }, "").start();

    }

}
