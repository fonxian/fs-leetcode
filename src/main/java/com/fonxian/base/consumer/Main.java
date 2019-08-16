package com.fonxian.base.consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Michael Fang
 * @since 2019-08-17
 */
public class Main {

    public static void main(String[] args) {

        BlockingQueue queue = new ArrayBlockingQueue(10);
//        ThreadPoolExecutor poolExecutor=new TraceThreadPool(5,5,20, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10));
        ExecutorService poolExecutor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 3; i++) {
            Customer customer = new Customer(queue);
            poolExecutor.submit(customer);
        }
        for (int i = 0; i < 5; i++) {
            Provider provider = new Provider(queue);
            poolExecutor.submit(provider);
        }

    }

}
