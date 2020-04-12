package com.szp.leetcode.common;

import java.util.*;

//     Definition for a binary tree node.
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public String printLevelOrder(){//层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.val);
            sb.append(node.val +",");
            if(null != node.left)
                queue.add(node.left);
            if(null != node.right)
                queue.add(node.right);
        }
        System.out.println("level order");
        return sb.toString();
    }

    public String printPreOrder(){//
        List<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        TreeNode cur  = this;
        while(cur != null || !queue.isEmpty()){
            while(cur != null){
                sb.append(cur.val+",");
                queue.add(0, cur);
                cur = cur.left;
            }
            cur = queue.remove(0).right;
        }
        System.out.println("pre order");
        return sb.toString();
    }

    public String printInOrder(){
        List<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        TreeNode cur  = this;
        while(cur != null || !queue.isEmpty()){
            while(cur != null){
                queue.add(0,cur);
                cur = cur.left;
            }
            cur = queue.remove(0);
            sb.append(cur.val + ",");
            cur = cur.right;
        }
        System.out.println("in order");
        return sb.toString();
    }

    public String printPostOrder(){
        List<TreeNode> queue = new LinkedList<>();
//        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        TreeNode cur  = this;
        while(cur != null || !queue.isEmpty()){
            while(cur != null){
                res.add(cur.val + "");
                queue.add(0,cur);
                cur = cur.right;
            }
            cur = queue.remove(0);
            cur = cur.left;
        }
        System.out.println("post order");
        Collections.reverse(res);
        return String.join(",",res);
    }
}
