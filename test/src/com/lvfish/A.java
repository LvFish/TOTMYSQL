package com.lvfish;

public class A {

    /**
     * 生成匿名内部类
     * @return 实现接口U的匿名内部类
     */
    public static U getU() {
        return new U() {
            @Override
            public void methodA() {
                System.out.println("实现U.A");
            }

            @Override
            public void methodB() {
                System.out.println("实现U.B");
            }

            @Override
            public void methodC() {
                System.out.println("实现U.C");
            }
        };
    }
}
