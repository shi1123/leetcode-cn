package com.szp.leetcode.interview;

public class A17_16_the_masseuse_lcci {
    class Solution {
        public int massage(int[] nums) {
            if(null == nums || nums.length == 0)
                return 0;
            if(nums.length == 1)
                return nums[0];
            int max =  Math.max(nums[0],nums[2]);
            int[] dp = new int[nums.length + 1];
            dp[0] = 0;
            dp[1] = nums[0];
            dp[2] = nums[1];
            max = Math.max(dp[1], dp[2]);
            for (int i = 2; i < nums.length; i++) {
                dp[i+1] = Math.max(nums[i] + dp[i-1], nums[i] + dp[i-2]);
                if(dp[i+1] > max)
                    max = dp[i+1];
            }
            return max;
        }
    }
/*
* 示例 1：

输入： [1,2,3,1]
输出： 4
解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
示例 2：

输入： [2,7,9,3,1]
输出： 12
解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
示例 3：

输入： [2,1,4,5,3,1,1,3]
输出： 12
解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。

链接：https://leetcode-cn.com/problems/the-masseuse-lcci
* */
    public static void main(String[] args) {
        Solution solution  = new A17_16_the_masseuse_lcci().new Solution();

        int[] nums = {1,2,3,1};
        System.out.println(solution.massage(nums));

        int[] nums1 = {2,7,9,3,1};
        System.out.println(solution.massage(nums1));
        int[] nums2 = {2,1,4,5,3,1,1,3};
        System.out.println(solution.massage(nums2));
        int[] nums3 = {2,1,1,2};
        System.out.println(solution.massage(nums3));
    }
}
