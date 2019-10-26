package com.yuu.interview.多线程;

/**
 * @author by Yuu
 * @Classname 等待唤醒机制
 * @Date 2019/10/24 19:32
 * @see com.yuu.interview.多线程
 */
public class 等待唤醒机制 {
    public static void main(String[] args) {
        /**
         * 线程间通信：
         * 多个线程在处理同一个资源，但是处理的动作（线程的任务）却不相同
         * 比如：线程A用来生成包子的，线程B用来吃包子的，包子可以理解为同一资源，
         * 线程A与线程B处理的动作，一个是生产，一个是消费，那么线程A与线程B之间就存在线程通信问题。
         */

        /**
         * 为什么要处理线程间通信：
         * 多个线程并发执行时, 在默认情况下CPU是随机切换线程的，
         * 当我们需要多个线程来共同完成一件任务，并且我们希望他们有规律的执行,
         * 那么多线程之间需要一些协调通信，以此来帮我们达到多线程共同操作一份数据。
         */

        /**
         * 如何保证线程间通信有效利用资源：
         * 多个线程在处理同一个资源，并且任务不同时，需要线程通信来帮助解决线程之间对同一个变量的使用或操作。
         * 就是多个线程在操作同一份数据时， 避免对同一共享变量的争夺。也就是我们需要通过一定的手段使各个线程能有效 的利用资源。
         * 而这种手段即—— 等待唤醒机制。
         */

        /**
         * 等待唤醒机制：
         * 什么是等待唤醒机制
         * 这是多个线程间的一种协作机制。谈到线程我们经常想到的是线程间的竞争（race），
         * 比如去争夺锁，但这并不是 故事的全部，线程间也会有协作机制。
         * 就好比在公司里你和你的同事们，你们可能存在在晋升时的竞争，但更多时候你们更多是一起合作以完成某些任务。
         * 就是在一个线程进行了规定操作后，就进入等待状态（wait()）， 等待其他线程执行完他们的指定代码过后再将其唤醒（notify()）;
         * 在有多个线程进行等待时， 如果需要，可以使用 notifyAll() 来唤醒所有的等待线程。 wait/notify 就是线程间的一种协作机制。
         */

        /**
         * 等待唤醒中的方法
         * 等待唤醒机制就是用于解决线程间通信的问题的，使用到的3个方法的含义如下：
         * 1. wait：线程不再活动，不再参与调度，进入 wait set 中，因此不会浪费 CPU 资源，
         * 也不会去竞争锁了，这时 的线程状态即是 WAITING。它还要等着别的线程执行一个特别的动作，
         * 也即是“通知（notify）”在这个对象 上等待的线程从wait set 中释放出来，重新进入到调度队列（ready queue）中
         * 2. notify：则选取所通知对象的 wait set 中的一个线程释放；例如，餐馆有空位置后，等候就餐最久的顾客最先 入座。
         * 3. notifyAll：则释放所通知对象的 wait set 上的全部线程。
         * 注意：
         * 哪怕只通知了一个等待的线程，被通知线程也不能立即恢复执行，因为它当初中断的地方是在同步块内，
         * 而 此刻它已经不持有锁，所以她需要再次尝试去获取锁（很可能面临其它线程的竞争），
         * 成功后才能在当初调 用 wait 方法之后的地方恢复执行。
         * 总结如下：
         * 如果能获取锁，线程就从 WAITING 状态变成 RUNNABLE 状态； 否则，
         * 从 wait set 出来，又进入 entry set，线程就从 WAITING 状态又变成 BLOCKED 状态
         */

        /**
         * 调用wait和notify方法需要注意的细节
         * 1. wait方法与notify方法必须要由同一个锁对象调用。
         * 因为：对应的锁对象可以通过notify唤醒使用同一个锁对象调用的wait方法后的线程。
         * 2. wait方法与notify方法是属于Object类的方法的。因为：锁对象可以是任意对象，而任意对象的所属类都是继承了Object类的。
         * 3. wait方法与notify方法必须要在同步代码块或者是同步函数中使用。因为：必须要通过锁对象调用这2个方法。
         */

        /**
         * 生产者与消费者问题:
         * 等待唤醒机制其实就是经典的“生产者与消费者”的问题。
         * 就拿生产包子消费包子来说等待唤醒机制如何有效利用资源：
         * 包子铺线程生产包子，吃货线程消费包子。
         * 当包子没有时（包子状态为false），吃货线程等待，
         * 包子铺线程生产包子 （即包子状态为true），
         * 并通知吃货线程（解除吃货的等待状态）,因为已经有包子了，
         * 那么包子铺线程进入等待状态。
         * 接下来，吃货线程能否进一步执行则取决于锁的获取情况。
         * 如果吃货获取到锁，那么就执行吃包子动作，包子吃完（包 子状态为false），
         * 并通知包子铺线程（解除包子铺的等待状态）,
         * 吃货线程进入等待。
         * 包子铺线程能否进一步执行则取 决于锁的获取情况。
         */

        BaoZi baoZi = new BaoZi();

        new Thread(new ChiHuo(baoZi)).start();
        new Thread(new BaoZiPu(baoZi)).start();
    }
}

class BaoZi {
    private String food;

    boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}

class ChiHuo implements Runnable {

    private BaoZi baoZi;

    public ChiHuo(BaoZi baoZi) {
        this.baoZi = baoZi;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (baoZi) {
                if (baoZi.isFlag()) {
                    System.out.println("吃货开始吃"+ baoZi.getFood() +"包子");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    baoZi.setFlag(false);
                    baoZi.notify();
                } else {
                    try {
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class BaoZiPu implements Runnable {

    private BaoZi baoZi;

    public BaoZiPu(BaoZi baoZi) {
        this.baoZi = baoZi;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (baoZi) {
                if (!baoZi.isFlag()) {
                    System.out.println("包子铺开始造包子");
                    baoZi.setFood("肉馅");
                    baoZi.setFlag(true);
                    baoZi.notify();
                } else {
                    try {
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}