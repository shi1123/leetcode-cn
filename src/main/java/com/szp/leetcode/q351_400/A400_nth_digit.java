package com.szp.leetcode.q351_400;

public class A400_nth_digit {
    class Solution {
        public int findNthDigit(int n) {
            if(n < 10)
                return n;
            int count = 1;
            int tmp = 0;
            while (n > tmp) {
                tmp += 9 * count*(int)Math.pow(10, count-1);
                System.out.println(count);
                count++;
                System.out.println((9 * count * (int)Math.pow(10, count - 1)));
                System.out.println(n);
            }
            n -= tmp;
            int num =(int) (n-1/count + Math.pow(10, count-1));
            String num_str = String.valueOf(num);
            if(n% count == 0) return num_str.charAt(count-1) -'0';
            else return num_str.charAt(n%count -1) -'0';


        }
    }

    public static void main(String[] args) {
        Solution solution = new A400_nth_digit().new Solution();
//        System.out.println(solution.findNthDigit(3));
        for (int i = 10; i <= 10; i++) {
            System.out.println("i=" + i);
            System.out.println(solution.findNthDigit(1000000000));

            System.out.println("*******");
        }
    }
}
