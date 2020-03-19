package com.szp.leetcode.q801_850;

import java.util.HashSet;
import java.util.Set;

/*
* [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
* */
public class A804_Unique_morse_code_words {
    class Solution {

        public int uniqueMorseRepresentations(String[] words) {
            if(null == words || words.length == 0)
                return 0;
            if(words.length == 1)
                return 1;
            String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                    "....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",
                    ".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
            int len = words.length;
            Set<String> codes = new HashSet<>(len);
            for(String s : words){
                StringBuilder stringBuilder = new StringBuilder();
                for(char c : s.toCharArray()){
                    stringBuilder.append(MORSE[c-'a']);
                }
                if(!codes.contains(stringBuilder.toString())){
                    codes.add(stringBuilder.toString());
                }
            }

            return codes.size();
        }
    }

    public static void main(String[] args) {
        Solution solution = new A804_Unique_morse_code_words().new Solution();
        String[] words = new String[]{"gin", "zen", "gig", "msg"};
        System.out.println(solution.uniqueMorseRepresentations(words));

    }
}
