package com.szp.leetcode.competition;

import java.util.ArrayList;
import java.util.List;

public class A5381 {
    class Solution {
        public int[] processQueries(int[] queries, int m) {
            int[] res = new int[queries.length];
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= m; i++) {
                list.add(i);
            }
            for (int i = 0; i < queries.length; i++) {

                int query = queries[i];
                int index = list.indexOf(query);
                res[i] = index;
                int tmp = list.remove(index);
                list.add(0, tmp);

            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new A5381().new Solution();
        int[] queries = {3,1,2,1};//, m = 5
        int[] queries2 = {4,1,2,2};//, m = 4
        int[] queries3 = {7,5,5,8,3};//, m = 8

        for (int i : solution.processQueries(queries, 5)) {
            System.out.print(i+",");
        }
        System.out.println();
        for (int i : solution.processQueries(queries2, 4)) {
            System.out.print(i+",");
        }
        System.out.println();
        for (int i : solution.processQueries(queries3, 8)) {
            System.out.print(i+",");
        }
        System.out.println();
//        System.out.println(solution.processQueries(queries2, 4));
//        System.out.println(solution.processQueries(queries3, 8));
    }
}
