package com.fonxian.base.juc.threadlocal;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Michael Fang
 * @since 2020-04-02
 */
public class GamePlayer {


    private static ThreadLocal<Integer> HP = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 1000;
        }
    };

    private static ThreadLocal<Integer> MP = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 500;
        }
    };

    public void event1() {
        int hp = HP.get() - new Random().nextInt(100);
        int mp = MP.get() - new Random().nextInt(100);
        System.out.println(Thread.currentThread().getName() + ":" + hp);
        HP.set(hp);
        MP.set(mp);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void event2() {
        int hp = HP.get() - new Random().nextInt(100);
        HP.set(hp);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void print() {
        System.out.println(Thread.currentThread().getName() + ":" + HP.get());
    }

}
