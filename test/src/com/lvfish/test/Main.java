package com.lvfish.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String args[]) {
        List<StringTest> stringTests = new ArrayList<>();
        stringTests.add(new StringTest("123", "234"));
        stringTests.add(new StringTest("234", "123"));
        stringTests.add(new StringTest("222", "333"));
        Collections.sort(stringTests);
        for (StringTest st : stringTests) {
            System.out.println(st);
        }


        List<StringTestCompare> stringTests2 = new ArrayList<>();
        stringTests2.add(new StringTestCompare("123", "234"));
        stringTests2.add(new StringTestCompare("234", "123"));
        stringTests2.add(new StringTestCompare("222", "333"));
        Collections.sort(stringTests2, new MyComparator2());
        for (StringTestCompare st : stringTests2) {
            System.out.println(st);
        }
    }
}