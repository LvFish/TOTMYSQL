package com.lvfish.homework;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args){
        System.out.println("测试AOP");
        TestImp test = new Test();
        TestInvocationHandler invocationHandler = new TestInvocationHandler(test);
        TestImp testProxy = (TestImp) Proxy.newProxyInstance(TestImp.class.getClassLoader(),new Class<?>[]{TestImp.class},invocationHandler);
        testProxy.testTransaction();
        testProxy.testLog();
        testProxy.testLogAndTransaction();
        testProxy.testWithoutAnnotation();

    }
}
