package com.szp.leetcode.q251_300;

public class A289_game_of_life {
    class Solution {
        public void gameOfLife(int[][] board) {
            int m = board.length, n = board[0].length;
            int[][] tmp = new int[m][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j< n; j++){
                    int state = board[i][j];
                    int live = getLiveAround(i,j,board);
                    if(state == 1){
                        if(live == 2 || live == 3)
                            tmp[i][j] = 1;
                    }else{
                        if(live == 3)
                            tmp[i][j] = 1;
                    }
                }
            }
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    board[i][j] = tmp[i][j];
                }
            }

        }

        private int getLiveAround(int x, int y, int[][] board){
            int m = board.length, n = board[0].length;
            int live = 0;
            int x1,y1;
            for(int i = -1; i < 2; i++){
                x1 = x+i;
                if(x1 < 0 || x1 == m)
                    continue;
                for(int j = -1; j < 2; j++){
                    y1 = y+j;
                    if(i == 0 && j == 0)
                        continue;
                    if(y1 < 0 || y1 == n)
                        continue;
                    if(board[x1][y1] == 1)
                        live++;
                }
            }
            return live;
        }
    }
}
