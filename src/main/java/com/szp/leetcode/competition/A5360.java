package com.szp.leetcode.competition;

import java.util.HashMap;
import java.util.Map;

public class A5360 {
    class Solution {
        public int countLargestGroup(int n) {
            if(n <= 9)
                return n;
            int[] counts = new int[37];
            Map<Integer,Integer> map = new HashMap<>();
            int sum = 0;
            int max = 0;
            for(int i = 1;i <= n;i++){
                sum = 0;
                int tmp = i;
                while( tmp> 0){
                    sum += tmp%10;
                    tmp = tmp/10;
                }
                counts[sum] += 1;
            }
            for(int count : counts){
                if(count == 0)
                    continue;
                if(map.containsKey(count))
                    map.put(count, map.get(count)+1);
                else{
                    map.put(count, 1);
                }
                if(count > max)
                    max = count;
            }
            return map.get(max);
        }
    }

    public static void main(String[] args) {
        Solution solution = new A5360().new Solution();
        System.out.println(solution.countLargestGroup(13));
        System.out.println(1/10);
    }
}

