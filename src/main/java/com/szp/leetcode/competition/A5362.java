package com.szp.leetcode.competition;

public class A5362 {
    class Solution {
        public boolean canConstruct(String s, int k) {
            if(s.length() < k)
                return false;
            if(s.length() == k)
                return true;
            int[] nums = new int[26];
            for(char c : s.toCharArray()){
                nums[c-'a'] += 1;
            }
            int single = 0;
            int two = 0;
            for(int count : nums){
                if(count % 2 == 1)
                    single++;
                two+=count /2;
            }
            if(single > k)
                return false;
            return single + two*2 >= k;
        }
    }
//    输入：s = "annabelle", k = 2
//    输出：true
//    解释：可以用 s 中所有字符构造 2 个回文字符串。
//    一些可行的构造方案包括："anna" + "elble"，"anbna" + "elle"，"anellena" + "b"
//    示例 2：
//
//    输入：s = "leetcode", k = 3
//    输出：false
//    解释：无法用 s 中所有字符构造 3 个回文串。
//    示例 3：
//
//    输入：s = "true", k = 4
//    输出：true
//    解释：唯一可行的方案是让 s 中每个字符单独构成一个字符串。
//    示例 4：
//
//    输入：s = "yzyzyzyzyzyzyzy", k = 2
//    输出：true
//    解释：你只需要将所有的 z 放在一个字符串中，所有的 y 放在另一个字符串中。那么两个字符串都是回文串。
//    示例 5：
//
//    输入：s = "cr", k = 7
//    输出：false
//    解释：我们没有足够的字符去构造 7 个回文串。
    public static void main(String[] args) {
        Solution solution = new A5362().new Solution();
//        System.out.println(solution.canConstruct("annabelle", 2));
//        System.out.println(solution.canConstruct("leetcode", 3));
//        System.out.println(solution.canConstruct("true", 4));
//        System.out.println(solution.canConstruct("yzyzyzyzyzyzyzy", 2));
//        System.out.println(solution.canConstruct("cr", 7));
//        System.out.println(solution.canConstruct("aaa", 2));
        System.out.println(solution.canConstruct("qlkzenwmmnpkopu", 15));
        System.out.println(solution.canConstruct("qlkzenwmmnpkopu", 15));
    }
}
