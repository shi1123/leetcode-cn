package com.szp.leetcode.competition;

import java.util.HashMap;
import java.util.Map;

public class A5382 {
    //    双引号：字符实体为 &quot; ，对应的字符是 " 。
//    单引号：字符实体为 &apos; ，对应的字符是 ' 。
//    与符号：字符实体为 &amp; ，对应对的字符是 & 。
//    大于号：字符实体为 &gt; ，对应的字符是 > 。
//    小于号：字符实体为 &lt; ，对应的字符是 < 。
//    斜线号：字符实体为 &frasl; ，对应的字符是 / 。
    class Solution {
//        Map<String, String> map = new HashMap<>();
//        {
//            map.put("&quot;","\"");
//            map.put("&apos;","'");
//            map.put("&amp;","&");
//            map.put("&gt;",">");
//            map.put("&lt;","<");
//            map.put("&frasl;","/");
//        }
        public String entityParser(String text) {
            int start = text.indexOf('&');
            int end = text.indexOf(';');

            if(start == -1 || end == -1){
                return text;
            }
            String textLeft = text.substring(0,end+1);
//            System.out.println("======" +textLeft);
            textLeft = textLeft.replace("&quot;","\"");
            textLeft = textLeft.replace("&apos;","'");
            textLeft =textLeft.replace("&amp;","&");
            textLeft =textLeft.replace("&gt;",">");
            textLeft =textLeft.replace("&lt;","<");
            textLeft =textLeft.replace("&frasl;","/");
//            System.out.println(textLeft);
//             for(Map.Entry<String, String>)
            if(end == text.length())
                return "";
            String textRight = text.substring(end+1);
            textRight = entityParser(textRight);
            return textLeft + textRight;
        }

//        public String entityParser(String text){
//
//        }
    }
//    示例 1：
//
//    输入：text = "&amp; is an HTML entity but &ambassador; is not."
//    输出："& is an HTML entity but &ambassador; is not."
//    解释：解析器把字符实体 &amp; 用 & 替换
//    示例 2：
//
//    输入：text = "and I quote: &quot;...&quot;"
//    输出："and I quote: \"...\""
//    示例 3：
//
//    输入：text = "Stay home! Practice on Leetcode :)"
//    输出："Stay home! Practice on Leetcode :)"
//    示例 4：
//
//    输入：text = "x &gt; y &amp;&amp; x &lt; y is always false"
//    输出："x > y && x < y is always false"
//    示例 5：
//
//    输入：text = "leetcode.com&frasl;problemset&frasl;all"
//    输出："leetcode.com/problemset/all"
    public static void main(String[] args) {
        Solution solution = new A5382().new Solution();
        String text = "&amp; is an HTML entity but &ambassador; is not.";
        System.out.println(solution.entityParser(text));
        text = "and I quote: &quot;...&quot;";
        System.out.println(solution.entityParser(text));
        text = "Stay home! Practice on Leetcode :)";
        System.out.println(solution.entityParser(text));
        text = "x &gt; y &amp;&amp; x &lt; y is always false";
        System.out.println(solution.entityParser(text));
        text = "leetcode.com&frasl;problemset&frasl;all";
        System.out.println(solution.entityParser(text));
//        String text = "abc";
//        System.out.println(text.substring(0, 3));
//        String textLeft = "&amp;";
//        System.out.println(textLeft.replace("&amp;", "&"));
    }
}
