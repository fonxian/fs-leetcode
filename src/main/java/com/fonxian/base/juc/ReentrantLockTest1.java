package com.fonxian.base.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Michael Fang
 * @since 2019-10-15
 */
public class ReentrantLockTest1 {

    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        Thread t1 = new Thread(){
            @Override
            public void run() {
                fun();
            }
        };
        t1.setName("线程1");

        Thread t2 = new Thread(){
            @Override
            public void run() {
                fun();
            }
        };
        t2.setName("线程2");

        t1.start();
        t2.start();


    }

    static void  fun(){

        lock.lock();
        try {
            TimeUnit.MILLISECONDS.sleep(20L);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
