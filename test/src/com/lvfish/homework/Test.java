package com.lvfish.homework;

public class Test implements TestImp{
    @Override
    @Transaction
    public void testTransaction(){
        System.out.println("方法使用Transaction注解");
    }

    @Override
    @Log
    public void testLog(){
        System.out.println("方法使用Log注解");
    }

    @Override
    @Transaction
    @Log
    public void testLogAndTransaction(){
        System.out.println("方法使用Log和Transaction注解");
    }

    @Override
    public void testWithoutAnnotation(){
        System.out.println("方法没有使用注解");
    }
}
