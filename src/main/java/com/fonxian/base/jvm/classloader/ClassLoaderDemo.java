package com.fonxian.base.jvm.classloader;

/**
 * @author Michael Fang
 * @since 2020-03-24
 */

class Father{

    public static final int a = 1;

    static{
        System.out.println("father");
    }

}

class Son extends Father{

    public static int b = 2;

    static {
        System.out.println("son");
    }

}


public class ClassLoaderDemo {

    static {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        System.out.println(Father.a);
    }

}
