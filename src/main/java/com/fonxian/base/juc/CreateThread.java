package com.fonxian.base.juc;

/**
 * @author Michael Fang
 * @since 2020-03-17
 */
public class CreateThread {

    static class Test implements Runnable{

        @Override
        public void run() {
            System.out.println("test");
        }
    }

    public static void main(String[] args) {
        new Thread(new Test()).start();
        System.out.println("test");
    }

}
