package com.szp.leetcode.q1_50;

public class A27_remove_element {
    class Solution {
        public int removeElement(int[] nums, int val) {
            if(null == nums || nums.length == 0)
                return 0;
            int len = nums.length;
            int j = len-1, i = 0;
            while(i<j){
                if(nums[i] == val ) {
                    nums[i] = nums[j];
                    j--;
                }else{
                    i++;
                }
            }
            return nums[i] == val ? i : i+1;
        }
    }
/*
* 示例 1:
    给定 nums = [3,2,2,3], val = 3,
    函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
    你不需要考虑数组中超出新长度后面的元素。
  示例 2:
    给定 nums = [0,1,2,2,3,0,4,2], val = 2,
    函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
    注意这五个元素可为任意顺序。
    你不需要考虑数组中超出新长度后面的元素。
* */
    public static void main(String[] args) {
        Solution solution = new A27_remove_element().new Solution();

        int[] nums1 = new int[]{3,2,2,3};
        System.out.println(solution.removeElement(nums1, 3));

        int[] nums2 = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(solution.removeElement(nums2, 2));

        int[] nums3 = new int[]{1};
        System.out.println(solution.removeElement(nums3, 1));
    }
}
