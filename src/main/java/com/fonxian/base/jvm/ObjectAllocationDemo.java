package com.fonxian.base.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @author Michael Fang
 * @since 2020-03-26
 */
public class ObjectAllocationDemo {

    public static void main(String[] args) {
        byte[] a = new byte[1024* 2 * 1024];
//        byte[] b = new byte[1024*2 * 1024];
//        byte[] c = new byte[300* 1024];
//        byte[] d = new byte[90* 1024];
//        byte[] e = new byte[1024* 4*1024];
//        byte[] f = new byte[90*10* 1024];
//        byte[] g = new byte[90* 1024];
//        byte[] g1 = new byte[20* 1024];
//        byte[] g2 = new byte[20*12* 1024];
//        byte[] g3 = new byte[20* 1024];
//        byte[] g4 = new byte[10*5* 1024];
//        byte[] g5 = new byte[10*5* 1024];

        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

}
