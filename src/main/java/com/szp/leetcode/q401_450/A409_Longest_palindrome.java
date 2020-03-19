package com.szp.leetcode.q401_450;
/*
* 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

注意:
假设字符串的长度不会超过 1010。

示例 1:

输入:
"abccccdd"

输出:
7

解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。*/
public class A409_Longest_palindrome {
    class Solution {
        public int longestPalindrome(String s) {
            if(null == s || s.length() == 0)
                return 0;
            if(s.length() == 1 )
                return 1;
            int len = s.length(),maxLen = 0;
            int[] charCount = new int[52];
            boolean hasSigleCharacter = false;
            for (int i = 0; i < len; i++) {
                int index;
                if(s.charAt(i) - 'a' >= 0){
                    index = s.charAt(i) - 'a' + 26;
                }else{
                    index = s.charAt(i) - 'A';
                }
                charCount[index] = charCount[index]+ 1;
            }

            for (int i = 0; i < 52; i++) {
                if(charCount[i] > 1){
                    if(charCount[i] % 2 == 0){
                        maxLen += charCount[i] ;
                    }else {
                        maxLen += charCount[i] -1;
                        hasSigleCharacter = true;
                    }
                }else if(charCount[i] == 1){
                    hasSigleCharacter = true;
                }else if(charCount[i] == 0){
                    continue;
                }
            }

            if(hasSigleCharacter){
                return  maxLen + 1;
            }else{
                return maxLen;
            }
        }

    }
    public static void main(String[] args) {
        A409_Longest_palindrome.Solution solution = new A409_Longest_palindrome().new Solution();
        String s = "abccccdd";
        System.out.println(solution.longestPalindrome(s));

        String s1 = "abeeccccdd";
        System.out.println(solution.longestPalindrome(s1));

//        "bb"
        String s2 = "dd";
        System.out.println(solution.longestPalindrome(s2));

        //        "bb"
        String s3 = "ccc";
        System.out.println(solution.longestPalindrome(s3));
//      "zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez"
        String s4 = "zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez";
        System.out.println(solution.longestPalindrome(s4));
//        "aaaAaaaa"
        String s5 = "aaaAaaaa";
        System.out.println(solution.longestPalindrome(s5));
        s.toCharArray();
    }
}
