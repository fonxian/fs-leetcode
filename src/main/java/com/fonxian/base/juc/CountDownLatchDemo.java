package com.fonxian.base.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author Michael Fang
 * @since 2019-10-17
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(10);
        for(int i = 0;i<10;i++){
            new Thread(new Latch(latch)).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("耗时xxxxx");
    }


}

class Latch implements Runnable{

    private CountDownLatch latch;

    public Latch(CountDownLatch countDownLatch){
       this.latch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("test");
        latch.countDown();
    }
}
