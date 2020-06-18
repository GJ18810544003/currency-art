package com.twilight.currency.art.first;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description: 实现多线程的三种方式
 * @Author: guojun
 * @Date: 2020/6/16
 */
public class ThreeMethodCurrency {

    public static class MyThread extends Thread {

        @Override
        public void run(){
            System.out.println("MyThread...");
        }
    }

    public static class RunnableTask implements Runnable {

        private static int k = 12;

        @Override
        public void run() {
            System.out.println(k);
            System.out.println("RunnableTask....");
        }

    }

    public static class CallerTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("CallerTask..");
            return "hello";
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        RunnableTask runnableTask = new RunnableTask();
        new Thread(runnableTask).start();
        new Thread(runnableTask).start();

        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        new Thread(futureTask).start();
        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
