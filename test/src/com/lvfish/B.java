package com.lvfish;

public class B {
    private U[] arraysU;        //存储U的引用
    private int size;           //存储数组的容量
    private int count;          //存储数组内元素数量

    /**
     * 对于B的初始化
     *
     * @param size 初始化的容量
     */
    B(int size) {
        arraysU = new U[size];
        this.size = size;
        this.count = 0;
    }

    /**
     * 默认初始化容量为10
     */
    B() {
        this.size = 10;
        this.count = 0;
        arraysU = new U[10];
    }

    /**
     * 添加U的引用
     *
     * @param u 传入U的引用并加入数组
     */
    public void addU(U u) {
        if (count < size) {
            arraysU[count++] = u;
        } else {
            System.out.println("空间已满");
        }
    }

    /**
     * 遍历数组里面的所有U的引用
     */
    public void iteratorU() {
        for (int i = 0; i < count; i++) {
            System.out.print(i + " ");
            arraysU[i].methodA();
            System.out.println();
        }
    }
}
