package com.szp.leetcode.interview;

public class A01_07_rotate_matrix_lcci {
    class Solution {
        public void rotate(int[][] matrix) {
            if (null == matrix || matrix.length == 0 || matrix.length == 1)
                return;
            int len = matrix.length;
            int n = len - 1;
            for (int i = 0; i < len / 2; i++) {
                for (int j = i; j < n - i; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[n - j][i];
                    matrix[n - j][i] = matrix[n - i][n - j];
                    matrix[n - i][n - j] = matrix[j][n - i];
                    matrix[j][n - i] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new A01_07_rotate_matrix_lcci().new Solution();

//        int[][] matrix = new int[][]{
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//        solution.rotate(matrix);
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix.length; j++) {
//                System.out.print(matrix[i][j] + ",");
//            }
//            System.out.print("\n");
//        }
        int[][] matrix = new int[][]{
                {5, 1, 9,11},
                {2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        solution.rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.print("\n");
        }
    }
}
