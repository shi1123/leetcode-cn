package com.szp.leetcode.p751_800;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
* 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。

示例:
输入: S = "a1b2"
输出: ["a1b2", "a1B2", "A1b2", "A1B2"]

输入: S = "3z4"
输出: ["3z4", "3Z4"]

输入: S = "12345"
输出: ["12345"]
注意：

S 的长度不超过12。
S 仅由数字和字母组成。
* */
public class A784_Letter_case_permutation {
    class Solution {
        public List<String> letterCasePermutation(String S) {
            if(null == S || S.length() == 0){
                return new ArrayList<>();
            }
            List<String> leftStr = new ArrayList<>();
            int len = S.length();
            String right= "";
            StringBuilder left= new StringBuilder();
            StringBuilder left2 = new StringBuilder();
            boolean hasLetter = false;
            for (int i = 0; i < len; i++) {
                char c = S.charAt(i);
                if(Character.isLetter(c)){
                    System.out.println("*****");
                    left.append(c);
                    char shiftC = (char) ((char)c^32);
                    left2.append(shiftC);

                    right = S.substring(i+1);

                    System.out.println("S:"+S);
                    System.out.println("right:"+right);
                    hasLetter = true;
                    break;
                }else{
                    left.append(c);
                    left2.append(c);
                }
            }
            if(right.length() != 0){
                List<String> rights = letterCasePermutation(right);
                for(String tmp : rights){
                    StringBuilder leftTmp = new StringBuilder(left);
                    StringBuilder leftTmp2 = new StringBuilder(left2);
                    leftStr.add(leftTmp.append(tmp).toString());
                    leftStr.add(leftTmp2.append(tmp).toString());
                }
            }else{
                if(hasLetter){
                    leftStr.add(left.toString());
                    leftStr.add(left2.toString());
                }else{
                    leftStr.add(left.toString());
                }
            }
            return leftStr;
        }

    }

/*
* 示例:
输入: S = "a1b2"
输出: ["a1b2", "a1B2", "A1b2", "A1B2"]

输入: S = "3z4"
输出: ["3z4", "3Z4"]

输入: S = "12345"
输出: ["12345"]
注意：
* */
    public static void main(String[] args) {
        Solution solution = new A784_Letter_case_permutation().new Solution();
//        String s = "abcde";
////        System.out.println(s.substring(0, 2));
////        System.out.println(String.valueOf((char) ('A' + 32)));
//        System.out.println(s.substring(5));

        String S = "a1b2";
        List<String> res = solution.letterCasePermutation(S);
        System.out.println("----------");
        res.forEach((item)->{
            System.out.println(item);
        });

        String S2 = "C";
        List<String> res2 = solution.letterCasePermutation(S2);
        System.out.println("----------");
        res2.forEach((item)->{
            System.out.println(item);
        });
    }
    class Solution2 {
        public List<String> letterCasePermutation(String s) {
            List<String> list=new LinkedList<>();
            if(s==null){
                return list;
            }
            int length=s.length();
            traverseWord(null,0,length,list,s);
            return list;
        }
        private void traverseWord(StringBuilder sb,int index,int length,List<String> list,String s){
            if(index==length){
                list.add(sb.toString());
                return;
            }
            StringBuilder eachStr=new StringBuilder();
            if(sb==null){
                sb=new StringBuilder();
            }
            eachStr.append(sb);
            char c=s.charAt(index);
            char cu = Character.toUpperCase(c);
            char cl = Character.toLowerCase(c);
            if(c!=cu){
                StringBuilder eachStr2=new StringBuilder(eachStr);
                eachStr2.append(cu);
                traverseWord(eachStr2,index+1,length,list,s);
            }
            if(c!=cl){
                StringBuilder eachStr2=new StringBuilder(eachStr);
                eachStr2.append(cl);
                traverseWord(eachStr2,index+1,length,list,s);
            }
            eachStr.append(c);
            traverseWord(eachStr,index+1,length,list,s);
        }
    }
}
