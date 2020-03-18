package com.szp.leetcode.q951_1000;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class A994_Rotting_oranges {

    class Solution {
        public int orangesRotting(int[][] grid) {
            int time = 0;
            return orangesRotting(grid, time );
        }
/*1、找出腐烂和未腐烂的橘子，放入队列中
    2、取出腐烂的橘子，感染它上下左右的，感染天数加1
    3、将被感染的橘子放入队列中，
    4、若腐烂的橘子为空，而未腐烂的不为空，返回-1
* */
        public int orangesRotting(int[][] grid, int time ){
            List<List<Integer>> rottedOranges = new ArrayList<>();
            List<List<Integer>> freshOranges = new ArrayList<>();
            int m = grid.length;
            int n = grid[0].length;
            int count = 0;
            int day = 0;


            for (int i = 0; i <m ; i++) {
                for (int j = 0; j < n; j++) {
                    if(grid[i][j] == 1){
                        List<Integer> freshOrange = new ArrayList<>(3);
                        freshOrange.add(i);
                        freshOrange.add(j);
                        freshOranges.add(freshOrange);
                    }else if(grid[i][j] == 2){
                        List<Integer> rottedOrange = new ArrayList<>(2);
                        rottedOrange.add(i);
                        rottedOrange.add(j);
                        rottedOranges.add(rottedOrange);
                    }
                }
            }

            while(!freshOranges.isEmpty()){
                if(rottedOranges.isEmpty()){
                    return -1;
                }
                int len = rottedOranges.size();
                for (int i = 0; i < len; i++) {
                    List<Integer> rottedOrange = rottedOranges.remove(0);
                    Iterator<List<Integer>> it = freshOranges.iterator();
                    while(it.hasNext()){
                        List<Integer> freshOrange = it.next();
                        if(canRotterd(rottedOrange, freshOrange)){
                            it.remove();
                            rottedOranges.add(freshOrange);
                        }
                    }
                }
                day++;
            }

            return day;
        }

        private boolean canRotterd(List<Integer> rottedOrange, List<Integer> freshOrange) {
            int ri = rottedOrange.get(0);
            int rj = rottedOrange.get(1);
            int fi = freshOrange.get(0);
            int fj = freshOrange.get(1);
            if(ri == fi){
                return Math.abs(rj -fj) == 1;
            }
            if(rj == fj){
                return Math.abs(ri -fi) == 1;
            }
            return false;
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
//        A994_Rotting_oranges.Solution solution = new A994_Rotting_oranges().new Solution();
////        [[2,1,1],[1,1,0],[0,1,1]]
//        int[][] grid1 = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
//        System.out.println(solution.orangesRotting(grid1));
//
//
////        [[2,1,1],[0,1,1],[1,0,1]]
//        int[][] grid2 = new int[][]{{2,1,1},{0,1,1},{1,0,1}};
//        System.out.println(solution.orangesRotting(grid2));
//
////        [[0,2]]
//        int[][] grid3 = new int[][]{{0,2}};
//        System.out.println(solution.orangesRotting(grid3));


        List<Integer> integers = new ArrayList();
        integers.add(1);
        integers.add(2);
        integers.add(3);

//        for (Integer integer : integers) {
//            integers.remove(1);
//        }
        int len = integers.size();
        for (int i = 0; i < len; i++) {
            integers.remove(0);
            System.out.println(integers.size());
        }
        System.out.println(integers);
    }
}
