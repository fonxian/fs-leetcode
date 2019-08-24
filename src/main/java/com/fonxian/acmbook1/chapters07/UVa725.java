package com.fonxian.acmbook1.chapters07;

import java.util.List;

/**
 * @author Michael Fang
 * @since 2019-08-24
 */
public class UVa725 {

    private List<String> division(int n){
        for(int i = 1234;i<=98765;i++){
            if(check(i) && check(i*n)){
                System.out.println("bingo");
            }
        }
        return null;
    }

    private boolean check(int i){
        return false;
    }

    public static void main(String[] args) {
        UVa725 uVa725 = new UVa725();
//        uVa725.division()
        int x = 1^1^2^2^3^3^4;
        System.out.println(x);

    }

}
