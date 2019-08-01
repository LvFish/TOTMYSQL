package com.lvfish;

public class SingleTon {

    private static SingleTon singleTon;

    /**
     * 单例的初始化
     */
    private SingleTon() {

    }

    /**
     * 获取单例对象
     * 首先判断是否为空
     * 然后加锁
     * 然后再判断是否为空，如果为空，初始化
     */
    public static SingleTon getSingleTon() {
        if (singleTon == null) {
            synchronized (singleTon) {
                if (singleTon == null) {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }


}
