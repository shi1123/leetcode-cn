package com.szp.leetcode.q851_900;

public class A887_super_egg_drop {
    class Solution {
        public int superEggDrop(int K, int N) {
            int[][] dp = new int[K + 1][N + 1];
//            int n = N;
//            int count = 0;
//            while (n >= 1) {
//                n = n / 2;
//                count++;
//            }
            for (int i = 1; i <= K; i++) {
                dp[i][1] = 1;
            }
            for (int i = 1; i <= N; i++) {
                dp[1][i] = i;
            }

            for (int j = 2; j <= N; j++) {
                int min = j;
                for (int i = 2; i <= K ; i++) {
                    System.out.println("tmpij");
                    for (int n = 1; n < N; n++) {
                        int tmpij = dp[i][n] + dp[i - 1][N-n] + 1;
//                        System.out.println(tmpij);
                        if(tmpij < min) {
                            System.out.println("tmpij:" + tmpij + " min:" + min + " n:" + n);
                            min = tmpij;
                        }
                    }
                    System.out.println("i:" + i + " j:" + j + " min:" + min);
                    dp[i][j] = min;
                }
            }
            return dp[K][N];
        }
        int superEggDrop2(int K, int N) {
            // m 最多不会超过 N 次（线性扫描）
            int[][] dp = new int[K + 1][N + 1];
            // base case:
            // dp[0][..] = 0
            // dp[..][0] = 0
            // Java 默认初始化数组都为 0
            int m = 0;
            while (dp[K][m] < N) {
                m++;
                for (int k = 1; k <= K; k++)
                    dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
            }
            return m;
        }

        private int getTime(int k,int n){
            if(n==1){
                return 1;
            }
            if(k==1){
                return n;
            }
            int left,right;
            //每次从中间楼层抛鸡蛋，left中间以下的楼层数，right中间以上的楼层数
            //每次鸡蛋碎了一定比鸡蛋没碎后续需要尝试的次数要多，所以只考虑鸡蛋碎的情况
            //奇数的时候，left=right数，如果鸡蛋碎了，后续getTime(k-1,n/2)肯定大于getTime(k,n/2)；
            //所以最大次数为1+getTime(k-1,n/2)
            if(n%2==1){
                left=getTime(k-1,n/2);
                right=left;
            }else{
                //偶数时，取左右两边次数较大的
                left=getTime(k-1,n/2-1);
                right=getTime(k,n/2);
            }
            if(left>right){
                return 1+left;
            }
            return 1+right;
        }

        private int getNext(int j) {
            for (int i = 0; i < 32; i++) {
                if (j > (int) Math.pow(2, i) && j <= (int) Math.pow(2, i + 1)) {
                    int res = (int) (j - Math.pow(2, i));
//                    System.out.println("j:" + j +" res:" + res);
                    return res;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new A887_super_egg_drop().new Solution();
//        System.out.println(solution.superEggDrop(1, 2));
//        System.out.println(solution.superEggDrop(2, 6));
//        System.out.println(solution.superEggDrop(3, 14));
//        System.out.println(solution.superEggDrop(1, 14));
//        System.out.println(solution.superEggDrop(2, 14));
//        System.out.println(solution.superEggDrop(1, 9));
//        System.out.println(solution.superEggDrop2(2, 9));
//        System.out.println(solution.getTime(2, 9));
                System.out.println(solution.superEggDrop(2, 9));
    }
}
