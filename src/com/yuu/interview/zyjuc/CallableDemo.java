package com.yuu.interview.zyjuc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author by Yuu
 * @Classname CallableDemo
 * @Date 2019/10/25 11:26
 * @see com.yuu.interview.zyjuc
 */
public class CallableDemo {

    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());

        new Thread(futureTask, "A").start();

        try {
            Integer result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("come in callable method...");
        return 1024;
    }
}
