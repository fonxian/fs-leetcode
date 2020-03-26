package com.fonxian.base.juc.countdownlatch;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

/**
 * @author Michael Fang
 * @since 2020-03-25
 */
public class CountDownLatchDemo2 {

    private static final ExecutorService threadPool = new ThreadPoolExecutor(50, 100,
            5, TimeUnit.SECONDS,
            new SynchronousQueue<>(),
            new BasicThreadFactory.Builder().namingPattern("thread-%d").build());


    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(2);
        // 收集数据A
        threadPool.execute(new TaskA(countDownLatch));
        // 收集数据B
        threadPool.execute(new TaskB(countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 进行统计工作
        System.out.println("进行统计工作");
        // 向上汇报
        System.out.println("向上汇报");
        System.out.println("任务结束");
        threadPool.shutdown();

    }

    static class TaskA implements Runnable {

        private CountDownLatch countDownLatch;

        public TaskA(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {

            try {
                System.out.println("执行任务A-----------");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("执行任务A完成");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class TaskB implements Runnable {

        private CountDownLatch countDownLatch;

        public TaskB(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {

            try {
                System.out.println("执行任务B-----------");
                TimeUnit.SECONDS.sleep(7);
                System.out.println("执行任务B完成");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
