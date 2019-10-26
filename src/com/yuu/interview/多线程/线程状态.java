package com.yuu.interview.多线程;

/**
 * @author by Yuu
 * @Classname 线程状态
 * @Date 2019/10/24 18:40
 * @see com.yuu.interview.多线程
 */
public class 线程状态 {

    private static Object object = new Object();

    public static void main(String[] args) {
        /**
         * 当线程被创建并启动以后，它既不是一启动就进入了执行状态，
         * 也不是一直处于执行状态。在线程的生命周期中， 有几种状态呢？
         * 在API中 java.lang.Thread.State 这个枚举中给出了六种线程状态：
         * 线程状态                     导致状态发生条件
         * NEW(新建)                    线程刚被创建，但是并未启动。还没调用start方法。
         * Runnable(可 运行)            线程可以在java虚拟机中运行的状态，可能正在运行自己代码，也可能没有，这取决于操作系统处理器。
         * Blocked(锁阻塞)             当一个线程试图获取一个对象锁，而该对象锁被其他的线程持有，则该线程进入 Blocked状 态；当该线程持有锁时，该线程将变成Runnable状态。
         * Waiting(无限等待)           一个线程在等待另一个线程执行一个（唤醒）动作时，该线程进入Waiting状态。进入这个状态后是不能自动唤醒的，必须等待另一个线程调用notify或者notifyAll方法才能够唤醒。
         * Timed Waiting(计时等待)     同waiting状态，有几个方法有超时参数，调用他们将进入Timed Waiting状态。这一状态 将一直保持到超时期满或者接收到唤醒通知。带有超时参数的常用方法有Thread.sleep 、 Object.wait。
         * Teminated(被终止)            因为run方法正常退出而死亡，或者因为没有捕获的异常终止了run方法而死亡。
         */

       /* new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if (i % 10 == 0) {
                    System.out.println("------------" + i);
                }
                System.out.print(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();*/

        /**
         *  Timed Waiting（计时等待）
         *  Timed Waiting在API中的描述为：一个正在限时等待另一个线程执行一个（唤醒）动作的线程处于这一状态。
         *  单独 的去理解这句话，真是玄之又玄，其实我们在之前的操作中已经接触过这个状态了，在哪里呢？
         * 在我们写卖票的案例中，为了减少线程执行太快，现象不明显等问题，我们在run方法中添加了sleep语句，
         * 这样就 强制当前正在执行的线程休眠（暂停执行），以“减慢线程”。
         * 其实当我们调用了sleep方法之后，当前执行的线程就进入到“休眠状态”，
         * 其实就是所谓的Timed Waiting(计时等 待)，那么我们通过一个案例加深对该状态的一个理解。
         */

        /**
         * BLOCKED（锁阻塞)
         *
         * Blocked 状态在 API 中的介绍为：一个正在阻塞等待一个监视器锁（锁对象）的线程处于这一状态。
         * 我们已经学完同步机制，那么这个状态是非常好理解的了。比如，线程A与线程B代码中使用同一锁，
         * 如果线程A获 取到锁，线程A进入到Runnable状态，那么线程B就进入到Blocked锁阻塞状态。
         * 这是由Runnable状态进入Blocked状态。除此Waiting以及Time Waiting状态也会在某种情况下进入阻塞状态，
         */

        /**
         * Waiting（无限等待）
         * Wating状态在API中介绍为：一个正在无限期等待另一个线程执行一个特别的（唤醒）动作的线程处于这一状态。
         * 那么我们之前遇到过这种状态吗？答案是并没有，但并不妨碍我们进行一个简单深入的了解。我们通过一段代码来 学习一下：
         */

        /*new Thread(() -> {
            synchronized (object) {
                System.out.println("等待线程获得锁，进入等待状态 ----");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("等待线程已被唤醒");
            }
        }, "等待线程").start();

        new Thread(() -> {
            synchronized (object) {
                System.out.println("唤醒线程获得锁，3秒后唤醒等待线程-----");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                object.notify();
            }
        }, "唤醒线程").start();*/
    }
}
