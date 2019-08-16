package com.fonxian.base.consumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author Michael Fang
 * @since 2019-08-17
 */
public class Customer implements Runnable {

    private BlockingQueue<Data> queue;

    public Customer(BlockingQueue<Data> queue) {
        this.queue = queue;
    }

    Random random = new Random();

    @Override
    public void run() {
        while (true) {
            try {
                Data data = queue.take();
                System.out.println("消费数据" + data.getData());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i = random.nextInt(1000);
            try {
                Thread.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
