package com.szp.leetcode.q1001_1050;

import com.szp.leetcode.q401_450.A409_Longest_palindrome;

import java.util.Stack;

/*
示例 1：

输入："(()())(())"
输出："()()()"
解释：
输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
示例 2：

输入："(()())(())(()(()))"
输出："()()()()(())"
解释：
输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
示例 3：

输入："()()"
输出：""
解释：
输入字符串为 "()()"，原语化分解得到 "()" + "()"，
删除每个部分中的最外层括号后得到 "" + "" = ""。
* */
public class A1021_Remove_outermost_parentheses {
    class Solution {
        public String removeOuterParentheses(String S) {
            if (S == null || S.length() == 0)
                return "";

            StringBuilder stringBuilder = new StringBuilder();
            int count = 0;
            for (char c : S.toCharArray()) {
                if (c == '(') {
                    count++;
                    if (count > 1)
                        stringBuilder.append(c);
                } else {
                    if (count > 1)
                        stringBuilder.append(c);
                    count--;
                }
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        A1021_Remove_outermost_parentheses.Solution solution = new A1021_Remove_outermost_parentheses().new Solution();
        String s = "(()())(())";
        System.out.println(solution.removeOuterParentheses(s));

        String s1 = "(()())(())(()(()))";
        System.out.println(solution.removeOuterParentheses(s1));

        String s3 = "()()";
        System.out.println(solution.removeOuterParentheses(s3));
    }
}
