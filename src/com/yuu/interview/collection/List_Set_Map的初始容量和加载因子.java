package com.yuu.interview.collection;

/**
 * @author by Yuu
 * @Classname List_Set_Map的初始容量和加载因子
 * @Date 2019/10/24 9:47
 * @see com.yuu.interview.collection
 */
public class List_Set_Map的初始容量和加载因子 {
    public static void main(String[] args) {
        // 1. List
            // (1) ArrayList 的初始容量是 10，加载因子是 0.5，扩容增量：原容量的 0.5 倍 + 1；一次扩容后的长度为 16
            // (2) Vector 的初始容量是 10，加载因子是 1，扩容增量：原容量的 1 倍，如 Vector 的容量为 10，一次扩容后的容量为 20
        // 2. Set
            // (1) HashSet 初始容量为 16，加载因子为 0.75，扩容增量：原容量的 1 倍，如 HashSet 的容量为 16，一次扩容后的容量为 32
        // 3. Map
            // (1) HashMap 初始容量为 16，加载因子为 0.75，扩容增量：原容量的 1 倍：如 HashMap 容量为 16，一次扩容后为 32
    }
}
