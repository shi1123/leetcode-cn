package com.szp.leetcode.q901_950;



public class A912_sort_an_array {
    // 归并排序
    class Solution1 {
        public int[] sortArray(int[] nums) {
            if(null == nums || nums.length == 0)
                return new int[0];
            if(nums.length == 1)
                return nums;
            int[] tmp = new int[nums.length];
            sortA(nums, 0, nums.length, tmp);
            return nums;
        }

        private void sortA(int[] nums, int low, int high, int[] tmp) {
            if(low < high){
                int mid = low + (high - low) /2;
                sortA(nums, low, mid, tmp);
                sortA(nums, mid + 1, high, tmp);
                merge(nums,low, mid,high,tmp);
            }
        }

        private void merge(int[] nums, int low, int mid, int high, int[] tmp) {
            int k = 0, i = low, j = mid+1;
            while(i<=mid && j <= high){
                if(nums[i] <= nums[j]) tmp[k++] = nums[i++];
                else tmp[k++] = nums[j++];
            }
            while(i<=mid){
                tmp[k++] = nums[i++];
            }
            while(j<=high){
                tmp[k++] = nums[j++];
            }
            System.arraycopy(tmp,0,nums,low,k);
        }
    }
}
