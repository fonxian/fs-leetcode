package com.fonxian.base.juc.semaphore;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author Michael Fang
 * @since 2020-03-25
 */
public class SemaphoreDemo {

    private static final ExecutorService threadPool = new ThreadPoolExecutor(20, 100,
            1, TimeUnit.MINUTES,
            new SynchronousQueue<>(),
            new BasicThreadFactory.Builder().namingPattern("thread-%d").build());

    private static volatile int count = 0;

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 100; i++) {
            threadPool.execute(() -> {
                try {

                    String id = new Random().nextInt() + "";
                    semaphore.acquire();
                    System.out.println("同事ID:" + id + ",开始体检");
                    try {
                        TimeUnit.SECONDS.sleep(3L);
                        TimeUnit.MILLISECONDS.sleep(new Random(10000).nextInt());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("同事ID:" + id + ",体检结束" + count);
                    count++;
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }

    }

}
