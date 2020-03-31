package com.szp.leetcode.q1150_1200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class A1162_as_far_from_land_as_possible {
    //超时
    class Solution {
        public int maxDistance(int[][] grid) {
            if (null == grid || grid.length == 0 || grid.length == 1)
                return -1;
            int m = grid.length;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    int num = grid[i][j];
                    if (num == 0) {
                        int max_local = searchNearestLand(i, j, grid);
                        if(-1 == max_local)
                            return -1;
                        if (max_local > max)
                            max = max_local;
                    }
                }
            }
            return max == Integer.MIN_VALUE ? -1 : max;
        }

        private int searchNearestLand(int i, int j, int[][] grid) {
            int m = grid.length;
            int min = Integer.MAX_VALUE;
            for (int a = 0; a < m; a++) {
                for (int b = 0; b < m; b++) {
                    int num = grid[a][b];
                    if (num == 1) {
                        int distance = Math.abs(i-a) + Math.abs(j-b);
                        if(distance < min)
                            min = distance;
                    }
                }
            }
            return min == Integer.MAX_VALUE ? -1 : min;
        }
    }
//超时
    class Solution1 {
        public int maxDistance(int[][] grid) {
            if (null == grid || grid.length == 0 || grid.length == 1)
                return -1;
            int m = grid.length;
            int res = 0;
            List<List<Integer>> lands = new LinkedList<>();
            List<List<Integer>> oceans = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    int num = grid[i][j];
                    List<Integer> location = new LinkedList<>();
                    location.add(i);
                    location.add(j);
                    if (num == 0) {
                        oceans.add(location);
                    }else{
                        lands.add(location);
                    }
                }
            }
            if(lands.size() == 0 || oceans.size() == 0)
                return -1;
            while(!oceans.isEmpty()){
                int len = lands.size();
                for (int i = 0; i < len; i++) {
                    List<Integer> land = lands.remove(0);
                    rot(lands, land, oceans);
                }
                res++;
            }
            return res;
        }

        private void rot(List<List<Integer>> lands, List<Integer> land, List<List<Integer>> oceans) {
            int len = oceans.size();
            for(int i = 0; i< len;i++){
                List<Integer> ocean = oceans.get(0);
                if((Math.abs(land.get(0) - ocean.get(0)) == 1 && (land.get(1) - ocean.get(1) == 0))
                || (Math.abs(land.get(1) - ocean.get(1)) == 1 && (land.get(0) - ocean.get(0) == 0))){
                    lands.add(ocean);
                    oceans.remove(ocean);
                }else{
                    oceans.remove(ocean);
                    oceans.add(ocean);
                }
            }
        }
    }

    class Solution3 {
        public int maxDistance(int[][] grid) {
            if (null == grid || grid.length == 0 || grid.length == 1)
                return -1;
            int len = grid.length;
            int res = 0;
            List<List<Integer>> lands = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    int num = grid[i][j];
                    if (num == 1) {
                        List<Integer> location = new LinkedList<>();
                        location.add(i);
                        location.add(j);
                        lands.add(location);
                    }
                }
            }
            if(lands.size() == 0 || lands.size() == len*len)
                return -1;
            while(!lands.isEmpty()){
                int l = lands.size();
                for (int i = 0; i < l; i++) {
                    List<Integer> land = lands.remove(0);
                    expand(lands, land, grid);
                }
                res++;
            }
            return res-1;
        }

        private void expand(List<List<Integer>> lands, List<Integer> land, int[][] grid) {
            int m = land.get(0);
            int n = land.get(1);
            if(m>0 && grid[m-1][n] == 0){
                List<Integer> list = new LinkedList<>();
                list.add(m-1);
                list.add(n);
                lands.add(list);
                grid[m-1][n] = 2;
            }
            if(m<grid.length-1 && grid[m+1][n] == 0){
                List<Integer> list = new LinkedList<>();
                list.add(m+1);
                list.add(n);
                lands.add(list);
                grid[m+1][n] = 2;
            }
            if(n>0 && grid[m][n-1] == 0){
                List<Integer> list = new LinkedList<>();
                list.add(m);
                list.add(n-1);
                lands.add(list);
                grid[m][n-1] = 2;
            }
            if(n < grid.length-1 && grid[m][n+1] == 0){
                List<Integer> list = new LinkedList<>();
                list.add(m);
                list.add(n+1);
                lands.add(list);
                grid[m][n+1] = 2;
            }
        }
    }

    public static void main(String[] args) {
        Solution3 solution = new A1162_as_far_from_land_as_possible().new Solution3();
        int[][] grid = {{1,0,1},{0,0,0},{1,0,1}};
        System.out.println(solution.maxDistance(grid));
        int[][] grid2 = {{1,0,0},{0,0,0},{0,0,0}};
        System.out.println(solution.maxDistance(grid2));
        int[][] grid3 = {{0,0,0},{0,0,0},{0,0,0}};
        System.out.println(solution.maxDistance(grid3));
        int[][] grid4 = {{1,1,1},{1,1,1},{1,1,1}};
        System.out.println(solution.maxDistance(grid4));
    }
}

