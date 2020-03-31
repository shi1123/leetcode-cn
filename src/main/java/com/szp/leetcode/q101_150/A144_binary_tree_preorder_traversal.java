package com.szp.leetcode.q101_150;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class A144_binary_tree_preorder_traversal {
    public class TreeNode {
        int val;
        A114_binary_tree_preorder_traversal.TreeNode left;
        A114_binary_tree_preorder_traversal.TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public List<Integer> preorderTraversal(A114_binary_tree_preorder_traversal.TreeNode root) {
            if(null == root)
                return new LinkedList<>();
            Stack<A114_binary_tree_preorder_traversal.TreeNode> stack = new Stack<>();
            List<Integer> res =  new LinkedList<>();
            stack.push(root);
            A114_binary_tree_preorder_traversal.TreeNode cur = root;
            while(!(root==null &&stack.isEmpty())){
                if(null != cur.right) {
                    stack.push(cur.right);
                }
                if(null != cur.left) {
                    stack.push(cur.left);
                }
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.left;
            }
            return res;
        }
    }
}
