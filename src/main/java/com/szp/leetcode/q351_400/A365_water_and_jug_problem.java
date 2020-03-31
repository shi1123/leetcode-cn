package com.szp.leetcode.q351_400;

public class A365_water_and_jug_problem {
    class Solution {
        public boolean canMeasureWater(int x, int y, int z) {
            if(z == 0)
                return true;
            if(x + y < z)
                return false;
            if(x == 0)
                return y == z;
            if(y == 0)
                return z == y;
            return  z % gcd(x,y) == 0;
        }

        private int gcd(int x, int y) {
            if(x < y){
                int tmp = x;
                x = y;
                y = tmp;
            }
            if(x % y == 0){
                return y;
            }

            return gcd(y, x % y);
        }
    }

    public static void main(String[] args) {
        Solution solution = new A365_water_and_jug_problem().new Solution();
        System.out.println(solution.canMeasureWater(3, 5, 4));
        System.out.println(solution.canMeasureWater(4, 6, 5));
    }
}
