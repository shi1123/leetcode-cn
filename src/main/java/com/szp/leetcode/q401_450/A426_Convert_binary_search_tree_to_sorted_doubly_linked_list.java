package com.szp.leetcode.q401_450;

public class A426_Convert_binary_search_tree_to_sorted_doubly_linked_list {

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    class Solution {
        public Node treeToDoublyList(Node root) {
            treeToDoublyListRecusive(root);

            Node nodeleft = root;
            while(nodeleft.left != null){
                nodeleft = nodeleft.left;
            }
            root.left = nodeleft;
            nodeleft.right = root;

            Node nodeRight = root;
            while(nodeRight.right != null){
                nodeRight = nodeRight.right;
            }
            nodeleft.left = nodeRight;
            nodeRight.right =nodeleft;
            return nodeleft;
        }

        public Node treeToDoublyListRecusive(Node root) {
            if(null != root.left){
                Node nodeleft = treeToDoublyListRecusive(root.left);
                while(nodeleft.right != null){
                    nodeleft = nodeleft.right;
                }
                root.left = nodeleft;
                nodeleft.right = root;
            }

            if(null != root.right) {
                Node nodeRight = treeToDoublyListRecusive(root.right);
                root.right = nodeRight;
                nodeRight.left = root;
                while (nodeRight.left != null) {
                    nodeRight = nodeRight.left;
                }
            }
            return root;
        }
    }
}
