package com.lvfish;

class TestException{
    public static String test1(){
        String i="123";
        try{
            return i;
        }catch (Exception e){
            return i;
        }finally {
            return "234";
        }
    }

    public static StringBuilder test2(){
        StringBuilder s = new StringBuilder("Hello");
        try{
            s.append("Word");
            return s;
        }catch (Exception e){
            return s;
        }finally {
            s.append("finally");
        }
    }
}
public class Main {

    public static void main(String[] args) {
        System.out.println(TestException.test1());
        System.out.println(TestException.test2());
    }
}