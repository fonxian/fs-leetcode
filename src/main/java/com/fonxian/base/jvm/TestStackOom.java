package com.fonxian.base.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Fang
 * @since 2020-04-15
 */
public class TestStackOom {

    public static void main(String[] args) {

        List<Thread> list = new ArrayList<>();

        Thread t = null;
        for (int i = 1; i <= 100; i++) {
            t = new Thread(() -> {
                try {
                    Thread.sleep(100_0000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            list.add(t);
            System.out.println("执行线程"+t.getName());
            t.start();
        }

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("任务完成");
    }


}

