package com.szp.leetcode.api.collection;

import java.util.Deque;
import java.util.LinkedList;

public class DequeLearn {
    public static void demo1(){
        Deque<String> deque = new LinkedList<>();

        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);

        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while ((deque.size() > 0)){
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }

    public static void deme2(){
        Deque<String> deque = new LinkedList<>();
        deque.addLast("b");
        deque.addLast("a");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while(deque.size() > 0){
            System.out.println(deque.pollFirst());
        }
        System.out.println(deque);


    }

    public static void main(String[] args) {
        DequeLearn.demo1();
        DequeLearn.deme2();



    }
}
