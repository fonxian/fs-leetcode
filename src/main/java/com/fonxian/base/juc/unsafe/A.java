package com.fonxian.base.juc.unsafe;

import sun.misc.Unsafe;

/**
 * @author Michael Fang
 * @since 2019-10-17
 */
public class A {

    private long a;
    private static final Unsafe unsafe = Unsafe.getUnsafe();

    public A() {
        this.a = 1;
    }

    public long a() {
        return this.a;
    }


    public static void main(String[] args) {
        try {
            A o3 = (A) unsafe.allocateInstance(A.class);

            System.out.println(o3.a);
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}
