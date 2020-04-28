package com.fonxian.base.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author Michael Fang
 * @since 2020-03-25
 */
public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        //TimeUnit.SECONDS.sleep(3000L);

        myThread.interrupt();
        System.out.println("执行线程中断");

    }

}

class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; ; i++) {


            System.out.println(123);
            try {
                TimeUnit.SECONDS.sleep(2000L);
            } catch (InterruptedException e) {

            }
            System.out.println("test----------");
        }
    }
}
