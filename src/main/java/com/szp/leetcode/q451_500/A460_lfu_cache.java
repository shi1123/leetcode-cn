package com.szp.leetcode.q451_500;

import com.szp.leetcode.q251_300.A300_LongestIncreasingSubsequence;

import java.util.*;

public class A460_lfu_cache {
    class LFUCache {
        int capacity;
        Queue<Node> queue;
        Map<Integer, Node> map;
        int idx = 0;
        public LFUCache(int capacity) {
            this.capacity = capacity;
            if (capacity > 0) {
                queue = new PriorityQueue<>(capacity);
            }
            map = new HashMap<>(capacity);
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
//                incFrq(node);
                node.frq++;
                node.idx = idx++;
                queue.remove(node);
                queue.offer(node);
                return node.value;
            } else {
                return -1;
            }
        }

//        private void incFrq(Node node) {
//
//        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            Node node = map.get(key);

            if(null == node){
                node = new Node(key, value, idx++);

                if (queue.size() == capacity) {
                    map.remove(queue.peek().key);
                    queue.poll();
                }
                map.put(key, node);
                queue.offer(node);
            }else{
                node.value = value;
                node.frq ++;
                node.idx = idx++;
                queue.remove(node);
                queue.offer(node);

            }
        }
    }

    public class Node implements Comparable<Node>{
        public int key;
        public int value;
        public int frq;
        public int idx;

        public Node(int key,int value,int idx){
            this.key = key;
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            int diff = frq - o.frq;
            return diff!=0 ? diff : idx - o.idx;
        }
    }

    /**
     * Your LFUCache object will be instantiated and called as such:
     * LFUCache obj = new LFUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     * LFUCache cache = new LFUCache( 2 );
     *
             *cache.put(1,1);
     *cache.put(2,2);
     *cache.get(1);       // 返回 1
     *cache.put(3,3);    // 去除 key 2
     *cache.get(2);       // 返回 -1 (未找到key 2)
     *cache.get(3);       // 返回 3
     *cache.put(4,4);    // 去除 key 1
     *cache.get(1);       // 返回 -1 (未找到 key 1)
     *cache.get(3);       // 返回 3
     *cache.get(4);       // 返回 4
     *

     */
    public static void main(String[] args) {
//        ["LFUCache","put","put","get","get","put","get","get","get"]
//[[2],[2,1],[3,2],[3],[2],[4,3],[2],[3],[4]]
        LFUCache cache = new A460_lfu_cache().new LFUCache( 2 );
        cache.put(2, 1);
        cache.put(3, 2);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        cache.put(4, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

        System.out.println(cache.get(2));
//        LFUCache cache = new A460_lfu_cache().new LFUCache( 2 );
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));
//        cache.put(3, 3);    // 去除 key 2
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(3));
//        cache.put(4, 4);    // 去除 key 1
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));

//["LFUCache","put","put","get","get","get","put","put","get","get","get","get"]
//[[3],[2,2],[1,1],[2],[1],[2],[3,3],[4,4],[3],[2],[1],[4]]

//        [null,null,null,2,1,2,null,null,-1,2,1,4]
//        LFUCache cache = new A460_lfu_cache().new LFUCache( 3 );
//        cache.put(2, 2);
//        cache.put(1, 1);
//
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));
//        cache.put(3, 3);    // 去除 key 2
//        cache.put(4, 4);    // 去除 key 2
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(4));


//        ["LFUCache","put","put","put","put","get"]
//[[2],[3,1],[2,1],[2,2],[4,4],[2]]
//        LFUCache cache = new A460_lfu_cache().new LFUCache( 2 );
//        cache.put(3, 1);
//        cache.put(2, 1);
//        cache.put(2, 2);
//        cache.put(4, 4);
//
//        System.out.println(cache.get(2));

//        ["LFUCache","put","put","get","put","put","get"]
//[[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
//        LFUCache cache = new A460_lfu_cache().new LFUCache( 2 );
//        cache.put(2, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(2));
//        cache.put(1, 1);
//        cache.put(4, 1);
//
//        System.out.println(cache.get(2));

    }
}
