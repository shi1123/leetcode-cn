package com.szp.leetcode.q1_50;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

/*
* 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
* */
public class A42_trapping_rain_water {
    class Solution {
        public int trap2(int[] height) {
            if(height == null || height.length <= 2)
                return 0;
            int count = 0;
            int start = 0,end = height.length -1;
            while(start < end){
                for (; start < height.length; start++) {
                    if(height[start] != 0)
                        break;
                }
                for (; end > start; end--) {
                    if(height[end] != 0)
                        break;
                }
                int minHeight = Integer.MAX_VALUE;
                for (int i = start; i <= end; i++) {
                    if(height[i] == 0)
                        continue;
                    minHeight = Math.min(height[i], minHeight);
                }
                for (int i = start; i <= end ; i++) {

                    if(height[i] == 0)
                        count += minHeight;
                    else
                        height[i] = height[i] -minHeight;
                }
            }
            return count;
        }

        public int trap(int[] height) {
            if(height == null || height.length <= 2)
                return 0;
            int count = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < height.length; i++) {
                while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                    int h = height[stack.peek()];
                    stack.pop();
                    if(stack.isEmpty())
                        break;
                    int distance = i - stack.peek() -1;
                    int h1 = Math.min(height[i], height[stack.peek()]) - h;
                    count += distance * h1;
                }
                stack.push(i);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new A42_trapping_rain_water().new Solution();
        int[] heights = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(heights));
        int[] heights2 = new int[]{2,0,2};
        System.out.println(solution.trap(heights2));
    }
}
