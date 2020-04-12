package com.szp.leetcode.q51_100;

import java.util.ArrayList;
import java.util.List;

public class A77_combinations {
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            if (k > n || n < 1)
                return new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            if (k == 1) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(n);
                res.add(tmp);
            }
            res.addAll(combine(n - 1, k));
            List<List<Integer>> preCombine = combine(n - 1, k - 1);
            for (List<Integer> list : preCombine) {
                list.add(n);
            }
            res.addAll(preCombine);
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new A77_combinations().new Solution();
        List<List<Integer>> combine = solution.combine(4, 2);
        for (List<Integer> list : combine) {
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.println(" ");
        }

    }


}
