package com.szp.leetcode.interview;
/*
*
* 示例 1：

输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
示例 2：

输入：arr = [0,1,2,1], k = 1
输出：[0]*/
public class A40_zui_xiao_de_kge_shu_lcof {
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if(null == arr || arr.length == 0 || k <= 0)
                return new int[]{};
            int[] topK = new int[k];
            topK[0] = arr[0];
             int counted = 1;
            for (int i = 1; i < arr.length; i++) {
                int j = 0;
                int tofit = arr[i];
                for (;j < counted; j++) {
                    if(counted < k){
                        topK[counted] = arr[i];
                        counted++;
                        break;
                    }else {
                        if (tofit < topK[j]) {
                            int tmp = topK[j];
                            topK[j] = tofit;
                            tofit = tmp;
                        }
                    }
                }
            }
            return topK;
        }
    }
/*
* 示例 1：

输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
示例 2：

输入：arr = [0,1,2,1], k = 1
输出：[0]
* */
    public static void main(String[] args) {
        Solution solution = new A40_zui_xiao_de_kge_shu_lcof().new Solution();
        int[] arr1 = new int[]{3,2,1};
        int k1 = 2;
        int[] res1 = solution.getLeastNumbers(arr1, k1);
        for (int i = 0; i < res1.length; i++) {
            System.out.println(res1[i]);
        }

        int[] arr2 = new int[]{0,1,2,1};
        int k2 = 1;
        int[] res2 = solution.getLeastNumbers(arr2, k2);
        for (int i = 0; i < res2.length; i++) {
            System.out.println(res2[i]);
        }
    }
}
