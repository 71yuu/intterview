package com.yuu.interview.多线程;

/**
 * @author by Yuu
 * @Classname 创建线程
 * @Date 2019/10/24 16:07
 * @see com.yuu.interview.多线程
 */
public class 创建线程 {

    public static void main(String[] args) {
        /**
         * Java使用 java.lang.Thread 类代表线程，所有的线程对象都必须是Thread类或其子类的实例。
         * 每个线程的作用是 完成一定的任务，实际上就是执行一段程序流即一段顺序执行的代码。
         * Java使用线程执行体来代表这段程序流。 Java中通过继承Thread类来创建并启动多线程的步骤如下：
         * 1. 定义Thread类的子类，并重写该类的run()方法，该run()方法的方法体就代表了线程需要完成的任务,因此把 run()方法称为线程执行体。
         * 2. 创建Thread子类的实例，即创建了线程对象
         * 3. 调用线程对象的start()方法来启动该线程
         */

        /*MyThread1 thread1 = new MyThread1("第一个线程");
        thread1.start();*/

        /**
         * 通过实现Runnable接口，使得该类有了多线程类的特征。
         * run()方法是多线程程序的一个执行目标。所有的多线程 代码都在run方法里面。
         * Thread类实际上也是实现了Runnable接口的类。
         * 在启动的多线程的时候，需要先通过Thread类的构造方法Thread(Runnable target) 构造出对象，
         * 然后调用Thread 对象的start()方法来运行多线程代码。
         * 实际上所有的多线程代码都是通过运行Thread的start()方法来运行的。因此，不管是继承Thread类还是实现 Runnable接口来实现多线程，
         * 最终还是通过Thread的对象的API来控制线程的，熟悉Thread类的API是进行多线程 编程的基础。
         */

        /**
         * tips:Runnable对象仅仅作为Thread对象的target，
         * Runnable实现类里包含的run()方法仅作为线程执行体。
         * 而实际的线程对象依然是Thread实例，只是该Thread线程负责执行其target的run()方法。
         */
        /*MyThread2 myThread2 = new MyThread2();
        Thread runnable = new Thread(myThread2, "Runnable");
        runnable.start();*/

        /**
         * Thread和Runnable的区别
         * 1. 如果一个类继承Thread，则不适合资源共享。但是如果实现了Runable接口的话，则很容易的实现资源共享
         * 实现Runnable接口比继承Thread类所具有的优势：
         * 1. 适合多个相同的程序代码的线程去共享同一个资源。
         * 2. 可以避免java中的单继承的局限性。
         * 3. 增加程序的健壮性，实现解耦操作，代码可以被多个线程共享，代码和线程独立。
         * 4. 线程池只能放入实现 Runable 或 Callable 类线程，不能直接放入继承Thread的类。
         * 扩充：在java中，每次程序运行至少启动2个线程。一个是main线程，一个是垃圾收集线程。
         * 因为每当使用 java命令执行一个类的时候，实际上都会启动一个JVM，每一个JVM其实在就是在操作系统中启动了一个进程。
         */
        /*MyThread3 myThread3 = new MyThread3();
        myThread3.start();
        MyThread3 myThread4 = new MyThread3();
        myThread4.start();*/
       /* MyThred4 myThred4 = new MyThred4();
        Thread thread = new Thread(myThred4);
        thread.start();
        Thread thread1 = new Thread(myThred4);
        thread1.start();*/

        /**
         * 匿名内部类创建线程
         * 使用线程的内匿名内部类方式，可以方便的实现每个线程执行不同的线程任务操作。
         * 使用匿名内部类的方式实现Runnable接口，重新Runnable接口中的run方法：
         */
        new Thread(() -> {
            System.out.println("123");
        }, "Hello").start();
    }
}

class MyThread1 extends Thread {

    /**
     * 定义指定线程名称的构造方法
     *
     * @param name 线程名称
     */
    public MyThread1(String name) {
        super(name);
    }

    /**
     * 重写 run 方法，完成该线程执行的逻辑
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " :正在执行！" + i);
        }
    }
}

class MyThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}

class MyThread3 extends Thread {
    private int tricket = 5;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                if (tricket > 0) {
                    System.out.println("卖出第" + tricket + "张票");
                    --tricket;
                }
            }
        }
    }
}

class MyThred4 implements Runnable {
    private int ticket = 5;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (ticket > 0) {
                System.out.println("卖出第" + ticket + "张票");
                --ticket;
            }
        }
    }
}