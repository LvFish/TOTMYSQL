package com.lvfish.test;

import java.util.Comparator;

class MyComparator2 implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        StringTestCompare s1 = (StringTestCompare)o1;
        StringTestCompare s2 = (StringTestCompare)o2;

        return s1.getStr2().compareTo(s2.getStr2());
    }
}

public class StringTestCompare {
    private String str1;
    private String str2;
    public String getStr2(){
        return str2;
    }
    StringTestCompare(String s1,String s2){
        str1  = s1;
        str2  = s2;
    }

    public String toString() {
        return "str1: " + str1 + " str2: " + str2;
    }
}
