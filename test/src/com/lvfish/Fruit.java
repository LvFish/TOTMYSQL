package com.lvfish;

public class Fruit {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(123);
    }
}
