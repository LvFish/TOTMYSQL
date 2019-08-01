package com.lvfish;

public class Client {
    public static void main(String args[]) {
        B b = new B(10);
        for (int i = 0; i < 6; i++) {
            b.addU(A.getU());
        }
        b.iteratorU();
    }
}
