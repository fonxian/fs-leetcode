package com.fonxian.base.juc.cyclicbarrier;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

/**
 * @author Michael Fang
 * @since 2020-03-25
 */
public class CyclicBarrierDemo2 {

    private static final ExecutorService threadPool = new ThreadPoolExecutor(50, 100,
            5, TimeUnit.SECONDS,
            new SynchronousQueue<>(),
            new BasicThreadFactory.Builder().namingPattern("thread-%d").build());

    private static volatile boolean flag = false;

    public static void main(String[] args) {

        CyclicBarrier cb = new CyclicBarrier(2);
        // 收集数据A
        threadPool.execute(new TaskA(cb));
        // 收集数据B
        threadPool.execute(new TaskB(cb));
        threadPool.shutdown();
    }

    static class TaskA implements Runnable {

        private CyclicBarrier cb;

        public TaskA(CyclicBarrier cb) {
            this.cb = cb;
        }

        @Override
        public void run() {

            try {
                System.out.println("执行任务A-----------");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("执行任务A完成");
                cb.await();
                if(!flag){
                    flag = true;
                    System.out.println("进行统计工作");
                    System.out.println("向上汇报");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    static class TaskB implements Runnable {

        private CyclicBarrier cb;

        public TaskB(CyclicBarrier cb) {
            this.cb = cb;
        }

        @Override
        public void run() {

            try {
                System.out.println("执行任务B-----------");
                TimeUnit.SECONDS.sleep(7);
                System.out.println("执行任务B完成");
                cb.await();
                if(!flag){
                    flag = true;
                    System.out.println("进行统计工作");
                    System.out.println("向上汇报");
                    System.out.println("任务结束");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}
