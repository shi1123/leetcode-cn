package com.szp.leetcode.api.collection;

import java.util.LinkedList;
import java.util.List;

public abstract class MyAbsatractList {
    List<String> list = new LinkedList<>();
    public MyIterable itrable(){
        return new It();
    }

    private class It implements MyIterable{
        private int a = 0;

        public int get(){
            return a;
        }
    }
}
