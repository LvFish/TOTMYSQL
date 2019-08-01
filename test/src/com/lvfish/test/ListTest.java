package com.lvfish.test;


import java.util.*;

class MyComparator implements Comparator{


    @Override
    public int compare(Object o1, Object o2) {
        return -o1.toString().compareTo(o2.toString());
    }
}

public class ListTest {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        String[] strings = {"aaa", "bbb", "ccc", "ddd"};
        String[] strings2 = {"aaa2", "bbb2", "ccc2", "ddd2", "eee2"};
        for (String s : strings) {
            arrayList.add(s);
        }
        for (String s : strings2) {
            linkedList.add(s);
        }
        ListIterator<String> arrayIterator = arrayList.listIterator();
        Iterator<String> linkIterator = linkedList.iterator();
        while (arrayIterator.hasNext()) {
            arrayIterator.next();
            arrayIterator.add(linkIterator.next());
            if (!linkIterator.hasNext()) {
                break;
            }
        }

        while (linkIterator.hasNext()) {
            arrayIterator.add(linkIterator.next());
        }
        MyComparator myComparator = new MyComparator();
        Collections.sort(arrayList,myComparator);
        linkIterator = arrayList.iterator();
        while (linkIterator.hasNext()) {
            System.out.println(linkIterator.next());
        }
    }
}
