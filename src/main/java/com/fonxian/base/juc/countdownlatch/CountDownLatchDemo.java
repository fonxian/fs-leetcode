package com.fonxian.base.juc.countdownlatch;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author Michael Fang
 * @since 2019-10-17
 */
public class CountDownLatchDemo {

    private static final ExecutorService threadPool = new ThreadPoolExecutor(50, 100,
            5, TimeUnit.SECONDS,
            new SynchronousQueue<>(),
            new BasicThreadFactory.Builder().namingPattern("thread-%d").build());

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 1; i <= 10; i++) {
            threadPool.execute(() -> {
                System.out.println("test-"+new Random().nextInt());
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        System.out.println("end");

    }

}
