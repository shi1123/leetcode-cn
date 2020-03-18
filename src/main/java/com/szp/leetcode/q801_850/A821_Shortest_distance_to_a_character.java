package com.szp.leetcode.q801_850;

import java.util.ArrayList;
import java.util.List;

/*821. 字符的最短距离
给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。

示例 1:

输入: S = "loveleetcode", C = 'e'
输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
说明:

字符串 S 的长度范围为 [1, 10000]。
C 是一个单字符，且保证是字符串 S 里的字符。
S 和 C 中的所有字母均为小写字母
* */
public class A821_Shortest_distance_to_a_character {
    class Solution {
        public int[] shortestToChar(String S, char C) {
            if (null == S || S.length() == 0)
                return new int[]{};

            int len = S.length();
            int[] distance = new int[len];
            List<Integer> locationC = new ArrayList<>();
            int countC = 0;
            for (int i = 0; i < len; i++) {
                if (C == S.charAt(i)) {
                    locationC.add(i);
                    countC++;
                }
            }
            for (int i = 0; i < len; i++) {
                char tmpC = S.charAt(i);
                if (tmpC == C) {
                    distance[i] = 0;
                    continue;
                }
                int shortDistance = Integer.MAX_VALUE;
                for (int j = 0; j < countC; j++) {
                    shortDistance = Math.min(shortDistance, Math.abs(locationC.get(j)- i));
                }
                distance[i] = shortDistance;
            }
            return distance;
        }
    }
}
