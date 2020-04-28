package com.fonxian.base.juc;

/**
 * @author Michael Fang
 * @since 2020-04-01
 */
public class MyTestLockTest {

    public static int count = 0;

    private static MyTestLock myTestLock = new MyTestLock();

    public static void main(String[] args) {

        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                myTestLock.lock();
                try {
                    for (int j = 1; j <= 1000; j++) {
                        count++;
                    }
                } finally {
                    myTestLock.unlock();
                }

            });
        }
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(count);

    }

}
