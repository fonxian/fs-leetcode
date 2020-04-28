package com.fonxian.base.java;

/**
 * @author Michael Fang
 * @since 2020-04-02
 */
public class GenericDemo1 implements GenericInterface<String>{

    public static void main(String[] args) {
        GenericDemo<String> a = new GenericDemo<>();
        a.setA("test");
        System.out.println(a.getA());

        GenericDemo<Integer> b = new GenericDemo<>();
        b.setA(1);
        System.out.println(b.getA());
    }

    @Override
    public String getT() {
        return "test";
    }
}
