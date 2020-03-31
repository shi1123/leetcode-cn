package com.szp.leetcode.q951_1000;

public class A999_available_captures_for_rook {
    class Solution {
        public int numRookCaptures(char[][] board) {
            int m= board.length;
            int n = board[0].length;

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(board[i][j] == 'R'){
                        return kill(i, j,board);
                    }
                }

            }
            return 0;
        }

        private int kill(int i, int j, char[][] board) {
            int pawn = 0;
            for (int k = i+1; k < 8; k++) {
                if(board[k][j] == 'B')
                    break;
                if(board[k][j] == 'p'){
                    pawn++;
                    break;
                }
            }
            for (int k = i-1; k > 0; k--) {
                if(board[k][j] == 'B')
                    break;
                if(board[k][j] == 'p'){
                    pawn++;
                    break;
                }
            }
            for (int k = j+1; k < 8; k++) {
                if(board[i][k] == 'B')
                    break;
                if(board[i][k] == 'p'){
                    pawn++;
                    break;
                }
            }            
            for (int k = j-1; k > 0; k--) {
                if(board[i][k] == 'B')
                    break;
                if(board[i][k] == 'p'){
                    pawn++;
                    break;
                }
            }
            return  pawn;
        }
    }
//    输入：[['.','.','.','.','.','.','.','.'],
//    ['.','.','.','p','.','.','.','.'],
//    ['.','.','.','R','.','.','.','p'],
//    ['.','.','.','.','.','.','.','.'],
//    ['.','.','.','.','.','.','.','.'],
//    ['.','.','.','p','.','.','.','.'],
//    ['.','.','.','.','.','.','.','.'],
//    ['.','.','.','.','.','.','.','.']]
//    输出：3
//
//    链接：https://leetcode-cn.com/problems/available-captures-for-rook
    public static void main(String[] args) {
        Solution solution = new A999_available_captures_for_rook().new Solution();
        
        char[][] board = new char[][]{
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','R','.','.','.','p'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'}
            };
        System.out.println(solution.numRookCaptures(board));

    }
}
