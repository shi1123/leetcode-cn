package com.szp.leetcode.q101_150;

import java.util.Arrays;

/*
* 输入: [100, 4, 200, 1, 3, 2]
输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
* */
public class A128_longest_consecutive_sequence {
    class Solution {
        public int longestConsecutive(int[] nums) {
            if(null == nums || nums.length <= 1 )
                return  nums.length;
            Arrays.sort(nums);
            int count = 1, length = nums.length;
            int longestConsecutive = 1;
            for (int i = 1; i < length; i++) {
                int current = nums[i];
                if(current == nums[i-1]+ 1)
                    count++;
                else if(current == nums[i-1]){
                    continue;
                }else {
                    longestConsecutive = Math.max(count, longestConsecutive);
                    count = 1;
                }
            }
            return Math.max(count, longestConsecutive);
        }
    }

    public static void main(String[] args) {
        Solution solution = new A128_longest_consecutive_sequence().new Solution();
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(nums));

        int[] nums1 = new int[]{0,0};
        System.out.println(solution.longestConsecutive(nums1));

        int[] nums2 = new int[]{0,-1};
        System.out.println(solution.longestConsecutive(nums2));
    }
}
