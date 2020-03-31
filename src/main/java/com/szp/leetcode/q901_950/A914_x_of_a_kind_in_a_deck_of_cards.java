package com.szp.leetcode.q901_950;

import java.util.*;

public class A914_x_of_a_kind_in_a_deck_of_cards {

    class Solution {
        public boolean hasGroupsSizeX(int[] deck) {
            if(null == deck || deck.length == 0)
                return false;
            Map<Integer, Integer> map = new HashMap<>();
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < deck.length; i++) {
                int key = deck[i];
                if(map.containsKey(deck[i])) {
                    map.put(deck[i], map.get(key) + 1);
                }else {
                    map.put(key, 1);
                }
            }
            for(Map.Entry<Integer,Integer> entry: map.entrySet()){
                min = Math.min(min, entry.getValue());
            }
            if(1 == min)
                return false;
            Set<Integer> divied = new HashSet<>();
            for (int i =  2; i <= min; i++) {
                if(min % i == 0){
                    divied.add(i);
                    min = min / i;
                }
            }
            Iterator<Integer> it = divied.iterator();
            while(it.hasNext()) {
                int groupNum = it.next();
                int count = 0;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue() % groupNum == 0)
                        count++;
                }
                if(count == map.size())
                    return true;
            }
            return false;
        }
    }
/*
* 示例 1：

输入：[1,2,3,4,4,3,2,1]
输出：true
解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
示例 2：

输入：[1,1,1,2,2,2,3,3]
输出：false
解释：没有满足要求的分组。
示例 3：

输入：[1]
输出：false
解释：没有满足要求的分组。
示例 4：

输入：[1,1]
输出：true
解释：可行的分组是 [1,1]
示例 5：

输入：[1,1,2,2,2,2]
输出：true
解释：可行的分组是 [1,1]，[2,2]，[2,2]
链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
* */
    public static void main(String[] args) {
        Solution solution = new A914_x_of_a_kind_in_a_deck_of_cards().new Solution();
        int[] deck = {1,2,3,4,4,3,2,1};
        System.out.println(solution.hasGroupsSizeX(deck));
        int[] deck1 = {1,1,1,2,2,2,3,3};
        System.out.println(solution.hasGroupsSizeX(deck1));
        int[] deck2 = {1};
        System.out.println(solution.hasGroupsSizeX(deck2));
        int[] deck3 = {1,1};
        System.out.println(solution.hasGroupsSizeX(deck3));
        int[] deck4 = {1,1,2,2,2,2};
        System.out.println(solution.hasGroupsSizeX(deck4));
        int[] deck5 = {0,0,0,1,1,1,2,2,2};
        System.out.println(solution.hasGroupsSizeX(deck5));
    }
}
