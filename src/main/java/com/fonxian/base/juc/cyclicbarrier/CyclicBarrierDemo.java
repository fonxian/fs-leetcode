package com.fonxian.base.juc.cyclicbarrier;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

/**
 * @author Michael Fang
 * @since 2020-03-25
 */
public class CyclicBarrierDemo {

    private static final ExecutorService threadPool = new ThreadPoolExecutor(50, 100,
            1, TimeUnit.MINUTES,
            new SynchronousQueue<>(),
            new BasicThreadFactory.Builder().namingPattern("thread-%d").build());

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                System.out.println("线程" + Thread.currentThread().getId() + "跑到100米，遇到栅栏，停下");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("继续跑完剩下300米");
            });
        }

        threadPool.shutdown();

    }

}
