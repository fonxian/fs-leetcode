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
        TimeUnit.SECONDS.sleep(3L);
        myThread.interrupt();
        System.out.println("执行线程中断");

    }

}

class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; ; i++) {
            System.out.println(this.isInterrupted());
            if (this.isInterrupted()) {
                System.out.println("线程终止");
                break;
            }
            System.out.println(i);
//            while(!this.isInterrupted()){
//
//            }
            try {
                TimeUnit.SECONDS.sleep(2L);
            } catch (InterruptedException e) {
                e.printStackTrace();
//                this.interrupt();
            }
            System.out.println("test----------");
        }
    }
}
