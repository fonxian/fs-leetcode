package com.fonxian.base.juc;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

/**
 * @author Michael Fang
 * @since 2020-04-21
 */
public class VolatileNoAutomicTest {

    public static ExecutorService threadPool = new ThreadPoolExecutor(2, 2,
            2, TimeUnit.SECONDS,
            // 不存储元素的阻塞队列
            new LinkedBlockingQueue<>(2),
            new BasicThreadFactory.Builder().namingPattern("thread-%d").build());

    public static volatile int count = 0;

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            threadPool.execute(() -> {
                for(int j = 1;j<10000000;j++){
                    count++;
                }
            });
        }
        threadPool.shutdown();
        while (!threadPool.isShutdown()){

        }
        System.out.println(count);
    }


}
