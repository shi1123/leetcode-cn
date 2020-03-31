package com.szp.leetcode.q801_850;

import java.util.*;

public class A820_short_encoding_of_words {
    class Solution {
        public int minimumLengthEncoding(String[] words) {
            if(null == words || words.length == 0)
                return 0;
            if(words.length == 1)
                return words[0].length();
            Set<String> set = new HashSet<>(Arrays.asList(words));

            Iterator<String> it = set.iterator();
            int res = 0;
            while(it.hasNext()){
                String word = it.next();
                Iterator<String> it2 = set.iterator();
                boolean flag = false;
                while(it2.hasNext()){
                    String word2 = it2.next();
                    if(word2.length() <= word.length()){
                        continue;
                    }else{
                        if(word2.indexOf(word) > 0){
                            flag = true;
                            break;
                        }
                    }
                }
                if(!flag)
                    res +=word.length() + 1;
            }
            return res;
        }
    }

    class Solution2 {
        public int minimumLengthEncoding(String[] words) {
            Set<String> good = new HashSet(Arrays.asList(words));
            for (String word: words) {
                for (int k = 1; k < word.length(); ++k)
                    good.remove(word.substring(k));
            }

            int ans = 0;
            for (String word: good)
                ans += word.length() + 1;
            return ans;
        }
    }

    class Solution3{
        public int minimumLengthEncoding(String[] words) {
            if(null == words || words.length == 0)
                return 0;
            if(words.length == 1)
                return words[0].length();
            TrieNode node = new TrieNode();
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                TrieNode cur = node;
                for (int j = word.length(); j > 0; j--) {
                    if(cur.children[word.charAt(j) - 'a'] == null)
                        cur.children[word.charAt(j) - 'a'] = new TrieNode();
                }
            }
            return 0;
        }
    }
    public class Trie{
        TrieNode root = new TrieNode();

        public int insertWord(String word){
            return 0;
        }

    }

    public class TrieNode{
        char c;
        TrieNode[] children = new TrieNode[26];
    }


/*
* words = ["time", "me", "bell"]
* */
    public static void main(String[] args) {
        Solution solution = new A820_short_encoding_of_words().new Solution();

        String[] words = {"me", "time", "bell"};

        System.out.println(solution.minimumLengthEncoding(words));


    }
}
