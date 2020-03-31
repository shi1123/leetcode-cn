package com.szp.leetcode.interview;

public class A62_yuan_quan_zhong_zui_hou_sheng_xia_de_shu_zi_lcof {
    class Solution {
        public int lastRemaining(int n, int m) {
            int res = 0;
            for (int i = 2; i <= n; i++) {
                res = (res + m) % i;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new A62_yuan_quan_zhong_zui_hou_sheng_xia_de_shu_zi_lcof().new Solution();
        System.out.println(solution.lastRemaining(5, 3));//3
        System.out.println(solution.lastRemaining(10, 17));//2
    }
}
