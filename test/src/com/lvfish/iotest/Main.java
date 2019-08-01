package com.lvfish.iotest;

import java.io.*;

public class Main {

    public static void readFile() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Users\\liujw-f\\Desktop\\test.txt"));
        Student stu;
        Object obj = null;
        while ((obj = in.readObject()) != null) {
            stu = (Student) obj;
            System.out.println(stu);
        }
        in.close();
    }

    public static void writeFile() throws IOException {
        Student student1 = new Student("qwe", 12, "123@qq.com");
        Student student2 = new Student("qwe2", 14, "1223@qq.com");
        Student student3 = new Student("qwe3", 16, "1213@qq.com");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("C:\\Users\\liujw-f\\Desktop\\test.txt")));
        out.writeObject(student1);
        out.writeObject(student2);
        out.writeObject(student3);
        out.close();
    }

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        writeFile();
        readFile();
    }
}
