package com.szp.leetcode.competition;

import java.util.Arrays;

public class A5363 {
    class Solution {
        public int maxSatisfaction(int[] satisfaction) {
            Arrays.sort(satisfaction);
            int n = satisfaction.length;
            if(satisfaction[n-1] <=0)
                return  0;
            int max = 0;
            int sum;
            for (int i = 0; i < n; i++) {
                sum = 0;
                for (int j = 0; j < n -i; j++) {
                    sum += satisfaction[j+i] * (j+1);
                }
                if(sum > max)
                    max = sum;
            }

            return max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new A5363().new Solution();
        int[] satisfaction = new int[]{-1,-8,0,5,-9};
        System.out.println(solution.maxSatisfaction(satisfaction));
        satisfaction = new int[]{4,3,2};
        System.out.println(solution.maxSatisfaction(satisfaction));
        satisfaction = new int[]{-1,-4,-5};
        System.out.println(solution.maxSatisfaction(satisfaction));
        satisfaction = new int[]{-2,5,-1,0,3,-3};
        System.out.println(solution.maxSatisfaction(satisfaction));
    }
}
