package com.fonxian.base.java;

/**
 * @author Michael Fang
 * @since 2020-03-24
 */
public class CloneDemo implements Cloneable{

    private int a;
    private int b;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
//        CloneDemo e1 = new CloneDemo();
//        try {
//            CloneDemo e2 = (CloneDemo)e1.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }

        int c = 15;
        // 1010 = 0101
        System.out.println(c + (c >> 1));

    }

}
