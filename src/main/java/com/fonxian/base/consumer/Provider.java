package com.fonxian.base.consumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Michael Fang
 * @since 2019-08-17
 */
public class Provider implements Runnable {

    private BlockingQueue<Data> queue;

    private static AtomicInteger integer = new AtomicInteger(0);

    public Provider(BlockingQueue<Data> queue) {
        this.queue = queue;
    }

    Random random = new Random();

    @Override
    public void run() {

        while (true) {
            int i = random.nextInt(100);
            try {//模拟数据耗时
                Thread.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Data data = new Data();
            data.setData(String.valueOf(integer.getAndIncrement()));
            try {
                if (!queue.offer(data, 20, TimeUnit.SECONDS)) {
                    System.out.println("offer error");
                }else{
                    System.out.println("生产数据:"+data.getData());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
