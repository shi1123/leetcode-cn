package com.szp.leetcode.q901_950;

import java.util.Arrays;

public class A945_minimum_increment_to_make_array_unique {
    class Solution {
        public int minIncrementForUnique(int[] A) {
            if(null == A || A.length == 0 || A.length == 1)
                return 0;
            Arrays.sort(A);
            int minInc = 0, len = A.length;
            for (int i = 0; i < len; i++) {
                for (int j = i+1; j < len; j++) {
                    if(A[j] == A[i]) {
                        A[j] = A[j] + 1;
                        minInc++;
                    }
                    else
                        break;
                }
            }
            return minInc;
        }
    }
    /*
    * 示例 1:

    输入：[1,2,2]
    输出：1
    解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
    示例 2:

    输入：[3,2,1,2,1,7]
    输出：6
    解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
    可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
    *
    * [3,2,1,2,1,7],6
    * */
    public static void main(String[] args) {
        Solution solution = new A945_minimum_increment_to_make_array_unique().new Solution();
        int[] nums = new int[]{1,2,2};
        System.out.println(solution.minIncrementForUnique(nums));

        int[] nums2 = new int[]{3,2,1,2,1,7};
        System.out.println(solution.minIncrementForUnique(nums2));

        int[] nums3 = new int[]{3,2,1,2,1,7};
        System.out.println(solution.minIncrementForUnique(nums2));
    }
}
