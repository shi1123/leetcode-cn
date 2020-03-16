package com.szp.leetcode.q1_50;
/*给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。
图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

示例：

输入：[1,8,6,2,5,4,8,3,7]
输出：49

链接：https://leetcode-cn.com/problems/container-with-most-water
* */
public class A11_Container_with_most_water {
    class Solution {
        public int maxArea(int[] height) {
            if (null == height || height.length == 0 || height.length == 1)
                return 0;
            int len = height.length;
            int maxArea = 0, tmpArea;
            for (int i = len-1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    tmpArea = (i - j) * Math.min(height[i], height[j]);
                    if (tmpArea > maxArea) {
                        maxArea = tmpArea;
                    }
                }
            }
            return maxArea;
        }
    }

    class Solution2 {
        public int maxArea(int[] height) {
            if (null == height || height.length == 0 || height.length == 1)
                return 0;
            int maxArea = 0, l = 0, r = height.length -1,tmpArea;
            while(l < r) {
                tmpArea = (r - l) * Math.min(height[l], height[r]);
                if (tmpArea > maxArea) {
                    maxArea = tmpArea;
                }
                if(height[l] < height[r]){
                    l++;
                }else{
                    r--;
                }
            }
            return maxArea;
        }
    }
/*
*
输入：[1,8,6,2,5,4,8,3,7]
输出：49

* */
    public static void main(String[] args) {
        A11_Container_with_most_water.Solution solution = new A11_Container_with_most_water().new Solution();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea(height));
        A11_Container_with_most_water.Solution2 solution2 = new A11_Container_with_most_water().new Solution2();
        System.out.println(solution2.maxArea(height));
    }

}
