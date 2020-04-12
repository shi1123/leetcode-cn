package com.szp.leetcode.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class A11_ji_qi_ren_de_yun_dong_fan_wei_lcof {
    class Solution {
        public int movingCount(int m, int n, int k) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> location = new ArrayList<>();
            location.add(0);
            location.add(0);
            list.add(location);
            int[][] visited = new int[m][n];
            visited[0][0] = 1;
            int sum = 1;
            while (list.size() != 0) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    List<Integer> l = list.get(0);
                    int x = l.get(0);
                    int y = l.get(1);

                    if (x + 1 < m && canMove(x + 1, y, k)) {
//                        System.out.println(x+1);
//                        System.out.println(y);
//                        System.out.println(sum);
                        if(visited[x+1][y] == 0){
                            List<Integer> next = new ArrayList<>();
                            next.add(x + 1);
                            next.add(y);
                            list.add(next);
                            sum++;
                            visited[x+1][y] = 1;
                        }

                    }
                    if (y + 1 < n && canMove(x, y + 1, k)) {
//                        System.out.println(x);
//                        System.out.println(y+1);
//                        System.out.println(sum);
                        if(visited[x][y+1] == 0) {
                            List<Integer> next = new ArrayList<>();
                            next.add(x);
                            next.add(y+1);
                            list.add(next);
                            sum++;
                            visited[x][y+1] = 1;
                        }

                    }
                    list.remove(0);
                }
            }
            return sum;
        }

        public boolean canMove(int i, int j, int k) {

            int sum = 0;
            while (i > 0) {
                sum += i % 10;
                i /= 10;
            }
            while (j > 0) {
                sum += j % 10;
                j /= 10;
            }
            return sum <= k;
        }
    }

    public static void main(String[] args) {
        Solution solution = new A11_ji_qi_ren_de_yun_dong_fan_wei_lcof().new Solution();
        System.out.println(solution.movingCount(2, 3, 1));
        System.out.println("++++++++++++++++");
        System.out.println(solution.movingCount(3, 1, 0));
        System.out.println("++++++++++++++++");
        System.out.println(solution.movingCount(3, 2, 17));
    }
}
