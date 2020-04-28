package com.fonxian.base.juc.threadlocal;

/**
 * @author Michael Fang
 * @since 2020-04-02
 */
public class GamePlayerDemo {

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                GamePlayer gamePlayer = new GamePlayer();
                gamePlayer.event1();
                gamePlayer.event2();
                gamePlayer.print();
            });
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
