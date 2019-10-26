package com.yuu.interview.base;

/**
 * @author by Yuu
 * @Classname JDK_JRE_JVM的联系与区别
 * @Date 2019/10/24 9:01
 * @see com.yuu.interview.base
 */
public class JDK_JRE_JVM的联系与区别 {
    public static void main(String[] args) {
        // 1. JDK
        // JDK 是 Java 开发工具包，包好了 Java 运行环境，以及一些开发所需要的组件
        // 2. JRE
        // JRE 是 Java 运行环境，运行 Java 程序所必须的，包含了 JVM
        // 3. JVM
        // JVM 是 Java 虚拟机，JVM 负责将字节码转换为特定的机器码，JVM 提供了内存管理/垃圾回收和安全机制等。
        // 4. 区别
        // （1）JDK 用于开发，JRE 用于运行 Java 程序
        // （2）JDK 和 JRE 都包含 JVM
        // （3）JVM 是 Java 编程语言的核心并且具有平台独立性
    }
}
