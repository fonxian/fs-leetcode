package com.fonxian.base.jvm.classloader;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author Michael Fang
 * @since 2020-03-25
 */
class A {
    static {
        System.out.println("A");
    }
}

public class ClassLoaderDemo2 {

    public static void main(String[] args) {
        System.out.println(String.valueOf("test"));
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
