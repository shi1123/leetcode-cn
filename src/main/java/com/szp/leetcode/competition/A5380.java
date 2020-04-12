package com.szp.leetcode.competition;

import java.util.ArrayList;
import java.util.List;

public class A5380 {
    class Solution {
        public List<String> stringMatching(String[] words) {
            List<String> res = new ArrayList<>();
            int len = words.length;
            for (int i = 0; i < len; i++) {
                String s1 = words[i];
                for (int j = 0; j < len; j++) {
                    String s2 = words[j];
                    if(s1.equals(s2)){
                        continue;
                    }
                    if(s2.contains(s1)) {
                        if(!res.contains(s1))
                            res.add(s1);
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new A5380().new Solution();
        String[] s = {"mass","as","hero","superhero"};
        System.out.println(solution.stringMatching(s));
        String[] s1 = {"leetcode","et","code"};
        System.out.println(solution.stringMatching(s1));
        String[] s2 = {"blue","green","bu"};
        System.out.println(solution.stringMatching(s2));
        String[] s3 = {"leetcoder","leetcode","od","hamlet","am"};
        System.out.println(solution.stringMatching(s3));
    }
}
