package com.szp.leetcode.competition;

public class A5361 {
    class Solution {
        public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
            double rec_x= ((double)x1+x2)/2;
            double rec_y= ((double)y1+y2)/2;
            double rec_radius = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1))/2;

            double distance = Math.sqrt((rec_x-x_center)*(rec_x-x_center)+(rec_y-y_center)*(rec_y-y_center));

            // //圆心在长方形中
            // if(x_center > x1 && x_center < x2 && y_center > y1 && y_center < y2)
            //     return true;
            // //相切
            // if(circle_left == x2 || circle_right == x1 || circle_down == y2 || circle_top == y1)
            //     return true;

            return distance < rec_radius + radius;
        }
    }

    public static void main(String[] args) {
        Solution solution = new A5361().new Solution();
//        System.out.println(solution.checkOverlap(1, 0, 0, 1, -1, 3, 1));
//        System.out.println(solution.checkOverlap(1, 0, 0, -1, 0, 0, 1));
//        System.out.println(solution.checkOverlap(1, 1, 1, -3, -3, 3, 3));
        System.out.println(solution.checkOverlap(1, 1, 1, 1, -3, 2, -1));
    }
}
