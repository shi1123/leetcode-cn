package com.szp.leetcode.q151_200;

public class A151_reverse_words_in_a_string {
    class Solution {
        public String reverseWords(String s) {
            if(null == s || s.length() == 0)
                return s;
             s = s.trim();
            String[] ss = s.split("\\s+");
            StringBuilder sb = new StringBuilder();
            for (int i = ss.length - 1; i >= 0; i--) {
                String s1 = ss[i];
//                if (" ".equals(s1) || "".equals(s1))
//                    continue;
                if (i != ss.length - 1)
                    sb.append(" " + s1);
                else
                    sb.append(s1);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        String s1 = " a good   example! ";
        Solution solution = new A151_reverse_words_in_a_string().new Solution();
        System.out.println(solution.reverseWords(s1));
        String s2 = "world! hello ";
    }
}
