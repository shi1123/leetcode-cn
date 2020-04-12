package com.szp.leetcode.interview;

public class A10_03_intersection_lcci {
    class Solution {
        public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
            double[] res = new double[2];
            int[] rate1 = getRate(start1, end1);
            int[] rate2 = getRate(start2, end2);
            //两直线平行的情况
            if (rate1[0] == rate2[0] && rate1[1] == rate2[1]) {
                if (rate1[2] != rate2[2]) {
                    return res;
                } else {
                    if((start1[0] >= end2[0] && start1[1] >= end2[1]) || (start2[0] >= end1[0])){
                        return res;
                    }
                    if (start1[0] == start2[0]) {
                        if (end1[1] < end2[1]) {
                            res[0] = end1[0];
                            res[1] = end1[1];
                        } else{
                            res[0] = end2[0];
                            res[1] = end2[1];
                        }
                    }
                }
            }
            return res;
        }

        private int[] getRate(int[] start1, int[] end1) {
            int x1 = start1[0], x2 = end1[0], y1 = start1[1], y2 = end1[1];
            int[] res = new int[3];
            int a = 0;
            if (x1 == x2) {
                res[0] = 1;
                res[1] = 0;
                res[2] = x1;
            } else if (y1 == y2) {
                res[0] = 0;
                res[1] = 1;
                res[2] = y1;
            } else {
                res[0] = (y1 - y2) / (x2 - x1);
                res[1] = 1;
                res[2] = -y1 + x1 * res[0];
            }
            return res;
        }
    }
}
