package com.lvfish.iotest;

public class Holder<T> {
    private T value;
    public Holder(){}
    public Holder(T val){
        value = val;
    }
    public T getValue(){
        return value;
    }

    public void setValue(T value){
        this.value = value;
    }
}
