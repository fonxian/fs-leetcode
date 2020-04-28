package com.fonxian.base.java;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Michael Fang
 * @since 2020-04-18
 */
public class WuTest1 {

    public static void main(String[] args) {
        Set<Character> shengmuSet = new HashSet<>();
        String s = "AabBpPmMfFdDtTnNlLɡGkKhHjJqQxXrRzZcCsSyYwWɡ";
//        String s = "AabBpPmMfFdDtTnNlLgGkKhHjJqQxXrRzZcCsSyYwW";//所有声母+A/a，因为有很多股票是带有A的，比如万科A，他的拼音简称是WKA。
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            shengmuSet.add(c);
        }

        System.out.println(shengmuSet.contains('g'));
        System.out.println(shengmuSet.contains('a'));
        System.out.println(shengmuSet.contains('b'));
        System.out.println(shengmuSet.contains('c'));
        System.out.println(shengmuSet.contains('d'));
        System.out.println(shengmuSet.contains('f'));

    }

}
