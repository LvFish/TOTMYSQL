package com.lvfish.iotest;


import java.util.ArrayList;
import java.util.List;
public class TestHolder {

    public static void printFruit(Holder<List<?>> holder){
        holder.setValue(null);
        holder.getValue().add(null);

    }

    public static void printFruit2(List<Holder<?>> list){

    }

    public static <T> void test(T t) {
        Holder holder = (Holder) t;
        List<?> list = (List<?>) holder.getValue();
        for (Object o : list) {
            System.out.println(o);
        }
//        list.add(new Object());
        list.add(null);
        holder.setValue(new ArrayList<>());
    }

    public static <T> void test2(T t) {
        List<Holder> list = (List) t;
        for (Holder o : list) {
            System.out.println(o.getValue());
            o.setValue(123);
        }
        list.add(new Holder<>(12.5));
        for (Holder o : list) {
            System.out.println(o.getValue());
            o.setValue(123);
        }

    }



    public static void main(String args[]) {
        List<?> list = new ArrayList();
        list.add(null);
        Holder<List<?>> holder = new Holder();
        holder.setValue(list);
        test(holder);
//        List<Holder<?>> list  = new ArrayList<>();
//        list.add(new Holder<>("asd"));
//        list.add(new Holder<>(123));
//        test2(list);
    }
}
