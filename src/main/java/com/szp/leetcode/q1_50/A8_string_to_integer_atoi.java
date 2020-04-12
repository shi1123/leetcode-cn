package com.szp.leetcode.q1_50;

public class A8_string_to_integer_atoi {
    class Solution {
        public int myAtoi(String str) {
            if(null == str || str == "")
                return 0;
            boolean positive = true;
            long res = 0;
            boolean first = true;
            for(char c : str.toCharArray()){
                if(' ' == c){
                    continue;
                }else if('-' == c) {//only consider one '-'
                    if(! first)
                        break;
                    positive = false;
                    first = false;
                }else if('+' == c) {
                    if(! first)
                        break;
                    first = false;
                    continue;
                }else if(c >= '0' && c <= '9') {
                    first = false;
                    res = res * 10 + c - '0';
                    if(res > Integer.MAX_VALUE)
                        break;
                }else{
                    break;
                }
            }
            if(positive){
                if(res > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                return (int)res;
            }else{
                if(res > Integer.MAX_VALUE)
                    return Integer.MIN_VALUE;
                return  -(int)res;
            }
        }
    }
//    示例 1:
//
//    输入: "42"
//    输出: 42
//    示例 2:
//
//    输入: "   -42"
//    输出: -42
//    解释: 第一个非空白字符为 '-', 它是一个负号。
//                 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
//    示例 3:
//
//    输入: "4193 with words"
//    输出: 4193
//    解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
//    示例 4:
//
//    输入: "words and 987"
//    输出: 0
//    解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
//    因此无法执行有效的转换。
//    示例 5:
//
//    输入: "-91283472332"
//    输出: -2147483648
//    解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
//                 因此返回 INT_MIN (−231) 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/string-to-integer-atoi
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static void main(String[] args) {
        Solution solution = new A8_string_to_integer_atoi().new Solution();
        String s1 = "42";
        String s2 = "   -42";
        String s3 = "4193 with words";
        String s4 = "words and 987";
        String s5 = "-91283472332";
        String s6 = "+1";
        String s7 = "  0000000000012345678";
        String s8 = "+-2";
        String s9 = "9223372036854775808";
        System.out.println(solution.myAtoi(s1));
        System.out.println(solution.myAtoi(s2));
        System.out.println(solution.myAtoi(s3));
        System.out.println(solution.myAtoi(s4));
        System.out.println(solution.myAtoi(s5));
        System.out.println(solution.myAtoi(s6));
        System.out.println(solution.myAtoi(s7));
        System.out.println(solution.myAtoi(s8));
        System.out.println(solution.myAtoi(s9));
    }
}
