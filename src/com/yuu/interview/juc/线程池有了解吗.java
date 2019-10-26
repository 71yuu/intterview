package com.yuu.interview.juc;

/**
 * @author by Yuu
 * @Classname 线程池有了解吗
 * @Date 2019/10/24 15:15
 * @see com.yuu.interview.juc
 */
public class 线程池有了解吗 {
    /**
     * java.util.concurrent.ThreadPoolExecutor 类就是一个线程池。客户端调用
     * ThreadPoolExecutor.submit(Runnable task) 提交任务，线程池内部维护的工作
     * 者线程的数量就是该线程池大小，有 3 中形态:
     * - 当前线程池大小：表示线程池中实际工作者线程的数量
     * - 最大线程池大小（maxinumPoolSize): 表示线程池中允许存在的工作者线程的数量上限
     * - 核心线程大小（corePoolSize)：表示一个不大于最大线程池大小的工作者线程数量上限
     * 1. 如果运行的线程少于 corePoolSize，则 Executor 始终首选将请求加入队列，而不进行排队
     * 2. 如果无法将请求加入队列，即队列已经满了，则创建新的线程，除非创建此线程超出 maxinumPoolSize，在这种情况下，任务将被拒绝。
     */
}
