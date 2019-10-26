package com.yuu.interview.collection;

/**
 * @author by Yuu
 * @Classname HashMap的长度为什么是2的幂次方
 * @Date 2019/10/24 9:33
 * @see com.yuu.interview.collection
 */
public class HashMap的长度为什么是2的幂次方 {
    public static void main(String[] args) {
        // 1. 通过将 key 的 hash 值与 length - 1 进行 & 运行，定位 key 的位置，减少 hash 碰撞，提高查询效率
        // 2. 为什么是 2 的幂次方呢，是因为 2 的幂次方 - 1 才能保证每位都是 1，这样才能不保证空间的浪费，如果length-1 二次方有个位置是 0 那个这个位置就不能用，就会增加 Hash 碰撞的几率，减少查询效率
    }
}
