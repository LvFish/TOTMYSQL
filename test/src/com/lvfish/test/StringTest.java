package com.lvfish.test;


public class StringTest implements Comparable {
    private String str1;
    private String str2;

    StringTest(String s1, String s2) {
        str1 = s1;
        str2 = s2;
    }

    @Override
    public int compareTo(Object o) {
        StringTest s2 = (StringTest) o;
        return this.str2.compareTo(s2.str2);
    }

    public String toString() {
        return "str1: " + str1 + " str2: " + str2;
    }
}
