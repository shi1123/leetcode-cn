package com.szp.leetcode.q851_900;

public class A892_surface_area_of_3d_shapes {
    class Solution {
        public int surfaceArea(int[][] grid) {
            if(null == grid || grid.length == 0)
                return 0;
            int zeros = 0;
            int left =0,top=0;
            int m=grid.length;
            int n =grid[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n ; j++) {
                    if(i==0){
                        top += grid[i][j];
                    }else{
                        if(grid[i][j] > grid[i-1][j]){
                            top += grid[i][j] - grid[i-1][j];
                        }
                    }
                    if(grid[i][j]== 0){
                        zeros++;
                    }
                }
            }
            for (int j = 0; j < n ; j++) {
                for (int i = 0; i < m; i++) {
                    if(j==0){
                        left += grid[i][j];
                    }else{
                        if(grid[i][j] > grid[i][j-1]){
                            left += grid[i][j] - grid[i][j-1];
                        }
                    }
                }
            }
            return ((m*n-zeros)+left+top)*2;
        }
    }
/*
* 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
请你返回最终形体的表面积。
示例 1：
输入：[[2]]
输出：10
示例 2：

输入：[[1,2],[3,4]]
输出：34
示例 3：

输入：[[1,0],[0,2]]
输出：16
示例 4：

输入：[[1,1,1],[1,0,1],[1,1,1]]
输出：32
示例 5：

输入：[[2,2,2],[2,1,2],[2,2,2]]
输出：46
提示：

1 <= N <= 50
0 <= grid[i][j] <= 50

* */
    public static void main(String[] args) {
        Solution solution = new A892_surface_area_of_3d_shapes().new Solution();
        int[][] grid = new int[][]{{2}};
        System.out.println(solution.surfaceArea(grid));

        int[][] grid1 = new int[][]{{1,2},{3,4}};
        System.out.println(solution.surfaceArea(grid1));

        int[][] grid2 = new int[][]{{1,0},{0,2}};
        System.out.println(solution.surfaceArea(grid2));

        int[][] grid3 = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        System.out.println(solution.surfaceArea(grid3));

        int[][] grid4 = new int[][]{{2,2,2},{2,1,2},{2,2,2}};
        System.out.println(solution.surfaceArea(grid4));

    }
}
