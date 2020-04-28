package com.fonxian.base.jvm;

/**
 * @author Michael Fang
 * @since 2020-04-19
 */
public class FullGCTest {

    private static final int _1MB = 1024 * 1024;

    public static void testPretenureSizeThreshold(){
        byte[] allocation;
        allocation = new byte[5 * _1MB];
    }

    public static void main(String[] args) {
        FullGCTest.testPretenureSizeThreshold();
    }

}
