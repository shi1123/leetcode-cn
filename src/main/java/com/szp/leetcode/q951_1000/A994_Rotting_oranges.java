package com.szp.leetcode.q951_1000;

public class A994_Rotting_oranges {

    class Solution {
        public int orangesRotting(int[][] grid) {
            int time = 0;
            return orangesRotting(grid, time );
        }

        public int orangesRotting(int[][] grid, int time ){
            int m = grid.length;
            int n = grid[0].length;
            boolean allRotting = true;

            for (int i = 0; i <m ; i++) {
                for (int j = 0; j < n; j++) {
                    if(grid[i][j] == 1){
                        allRotting = false;
                    }
                }
            }

            for (int i = 0; i <m ; i++) {
                for (int j = 0; j < n; j++) {
                    if(grid[i][j] == 1){
                        allRotting = false;
                    }else if(grid[i][j] == 2){
                        rotate(grid, i, j);
                    }
                }
            }
            if (!allRotting){
                time += 1;
            }else{
                return time;
            }
            time = orangesRotting(grid, time);
            return time;
        }

        private void rotate(int[][] grid, int i, int j) {
            int m = grid.length;
            int n = grid[0].length;
            //top,down
            if(i != 0){
                grid[i-1][j] = grid[i-1][j] == 0? 0: 2;
            }
            //down
            if(i != m-1){
                grid[i+1][j] = grid[i+1][j] == 0? 0: 2;
            }
            //left
            if(j != 0){
                grid[i][j-1] = grid[i][j-1] == 0? 0: 2;
            }
            //right
            if(j != n-1){
                grid[i][j+1] = grid[i][j+1] == 0? 0: 2;
            }
            grid[i][j] = grid[i][j]+ 1;
        }
    }

    public static void main(String[] args) {
        A994_Rotting_oranges.Solution solution = new A994_Rotting_oranges().new Solution();
//        [[2,1,1],[1,1,0],[0,1,1]]
        int[][] grid1 = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(solution.orangesRotting(grid1));
    }
}
