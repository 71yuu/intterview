package com.yuu.interview.juc;

/**
 * @author by Yuu
 * @Classname 如何指定多个线程的执行顺序
 * @Date 2019/10/24 11:15
 * @see com.yuu.interview.juc
 */
public class 如何指定多个线程的执行顺序 {
    public static void main(String[] args) {
        // 思路
        // 1. 设定一个 orderNum，每个线程执行结束之后，更新 orderNum，指明下一个要执行的线程。并且唤醒所有的等待线程
        // 2. 在每一个线程开始，要 while 判断 orderNum 是否等于自己的要求值！！不是，则 wait,是否执行本线程

        LockObject lockObject = new LockObject();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                new MyThread(lockObject, i).start();
            }
        }, "").start();
    }
}

class LockObject {
    private int orderNum = 0;
    private int maxNum = 9;

    public int getMaxNum() {
        return maxNum;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
}

class MyThread extends Thread {

    private LockObject lockObject;
    private int myNum;

    public MyThread(LockObject lockObject, int myNum) {
        this.lockObject = lockObject;
        this.myNum = myNum;
    }

    @Override
    public void run() {
        synchronized (lockObject) {
            while (lockObject.getOrderNum() <= lockObject.getMaxNum()) {
                if (this.myNum == this.lockObject.getOrderNum()) {
                    System.out.print(this.myNum);
                    int orderNum = this.lockObject.getOrderNum() + 1;
                    this.lockObject.setOrderNum(orderNum);
                    lockObject.notifyAll();
                } else {
                    try {
                        lockObject.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}