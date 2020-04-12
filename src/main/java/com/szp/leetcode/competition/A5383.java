package com.szp.leetcode.competition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A5383 {
    //for 选择 in 选择列表:
//        # 做选择
//        将该选择从选择列表移除
    //    路径.add(选择)
    //    backtrack(路径, 选择列表)
    //    # 撤销选择
    //    路径.remove(选择)
    //    将该选择再加入选择列表
    class Solution {
        List<Integer> choices = new ArrayList<>();
        {
            choices.add(1);
            choices.add(2);
            choices.add(3);
        }
        public int numOfWays(int n) {
            int[][] mark = new int[n][3];
            return numOfWays(mark,0,0,choices);
        }

        public int numOfWays(int[][] marks, int i, int j, List<Integer> choices) {
            if(j == 3){
                j = 0;
                i++;
            }
            if(i == marks.length)
                return -1;

            for (int k = 0; k < choices.size(); k++) {
                int color = choices.remove(0);
                if(canPaint(marks,i, j, color)){

                }
            }

            return -1;
        }

        private boolean canPaint(int[][] marks, int i, int j, int color) {
            int m = marks.length;
            int n = marks[0].length;

            if(i-1 > 0){
                if(color == marks[i-1][j])
                return false;
            }
            if(j-1 > 0 ){
                if(color ==  marks[i][j-1])
                    return false;
                return color != marks[i-1][j] && color != marks[i][j-1];
            }
            return true;
        }
    }
}
