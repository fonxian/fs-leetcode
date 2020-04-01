package com.fonxian;

/**
 * @author Michael Fang
 * @since 2020-03-30
 */
public class Test {

    public static void main(String[] args) {
        int cap = 13;
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println(n + 1);
        String a = "test";
        System.out.println(a.hashCode());
        for (int i = 1; i < 100; i++) {
            System.out.println("-------" + i + "--------");
            System.out.println(((i - 1) & a.hashCode()));
            System.out.println((a.hashCode() % (i)));
            System.out.println((a.hashCode() % (i) == ((i - 1) & a.hashCode())));
            System.out.println("---------------");
        }
    }


}
