package com.szp.leetcode.api.collection;

public class MyClass extends MyAbsatractList {
    public MyIterable itrable(){
        return super.itrable();
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        System.out.println(myClass.itrable().get());
    }
}
