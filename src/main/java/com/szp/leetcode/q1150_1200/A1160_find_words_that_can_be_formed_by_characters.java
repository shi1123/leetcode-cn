package com.szp.leetcode.q1150_1200;

import java.util.HashMap;
import java.util.Map;

/*
* 输入：words = ["cat","bt","hat","tree"], chars = "atach"
输出：6
解释：
可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
*
输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
输出：10
解释：
可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。

链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
* */
public class A1160_find_words_that_can_be_formed_by_characters {
    class Solution {
        public int countCharacters(String[] words, String chars) {
            if(null == chars || chars.length() == 0 || null == words || words.length == 0){
                return 0;
            }
            int len = words.length;
            int result = 0;
            Map<String ,Integer > charCanBeUse = new HashMap<>();
            getCharCountMap(chars, charCanBeUse);

            for (int i = 0; i < len; i++) {
                String word = words[i];
                Map<String ,Integer> wordCharCounts = new HashMap<String ,Integer>();
                getCharCountMap(word, wordCharCounts);
                if(charCanBeUse.size() < wordCharCounts.size()){
                    continue;
                }
                boolean canSpell = true;
                for(Map.Entry<String, Integer> entry : wordCharCounts.entrySet()){
                    if(!charCanBeUse.containsKey(entry.getKey()) || charCanBeUse.get(entry.getKey()) < entry.getValue()){
                        canSpell = false;
                    }

                }
                if (canSpell) {
                    result += word.length();
                }
            }
            return result;
        }

        private void getCharCountMap(String chars, Map<String, Integer> charCanBeUse) {
            for(int i = 0; i < chars.length();i++){
                String s = "" + chars.charAt(i);
                if(charCanBeUse.containsKey(s)){
                    int count = charCanBeUse.get(s);
                    charCanBeUse.put(s, count + 1);
                }else{
                    charCanBeUse.put(s,1);
                }
            }
        }
    }

    public static void main(String[] args) {
        A1160_find_words_that_can_be_formed_by_characters.Solution solution = new  A1160_find_words_that_can_be_formed_by_characters().new Solution();

//        words = ["cat","bt","hat","tree"], chars = "atach"
        String[] words = new String[]{"cat","bt","hat","tree"};
        System.out.println(solution.countCharacters(words, "atach"));

    }
}
