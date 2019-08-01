package com.lvfish.test;

class TestThread1 extends Thread {
    private StringBuilder builder;
    private StringBuffer buffer;

    public TestThread1(String name) {
        super(name);
    }

    public void setBuilder(StringBuilder builder, StringBuffer buffer) {
        this.builder = builder;
        this.buffer = buffer;
    }

    public void run() {
        System.out.println("线程1");
        for (int i = 0; i < 15; i++) {
            builder.append("A" + i);
            buffer.append("A" + i);

        }


    }
}

class TestThread2 extends Thread {
    private StringBuilder builder;
    private StringBuffer buffer;

    public TestThread2(String name) {
        super(name);
    }

    public void setBuilder(StringBuilder builder, StringBuffer buffer) {
        this.builder = builder;
        this.buffer = buffer;
    }


    public void run() {
        System.out.println("线程2");
        for (int i = 0; i < 15; i++) {
            buffer.append("B" + i);
            builder.append("B" + i);
        }


    }
}

public class ThreadTest {
    public static void main(String args[]) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
        TestThread1 testThread1 = new TestThread1("测试1");
        TestThread1 testThread3 = new TestThread1("测试1");
        TestThread1 testThread4 = new TestThread1("测试1");
        TestThread1 testThread5 = new TestThread1("测试1");
        TestThread2 testThread2 = new TestThread2("测试2");
        testThread1.setBuilder(stringBuilder, stringBuffer);
        testThread2.setBuilder(stringBuilder, stringBuffer);
        testThread3.setBuilder(stringBuilder, stringBuffer);
        testThread4.setBuilder(stringBuilder, stringBuffer);
        testThread5.setBuilder(stringBuilder, stringBuffer);
        testThread1.start();
        testThread2.start();
        testThread3.start();
        testThread4.start();
        testThread5.start();
        try {
            testThread1.join();
            testThread2.join();
            testThread3.join();
            testThread4.join();
            testThread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(stringBuilder.toString());
        System.out.println(stringBuffer.toString());
    }
}
