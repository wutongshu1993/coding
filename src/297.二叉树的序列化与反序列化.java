/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */

// @lc code=start


import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    String SEP = ",";
    String NULL = "null";
    String res;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // String a = transfer(root);
        // System.out.println(a);
        return transfer(root);
    }
    public String transfer(TreeNode root){
        if(root == null){
            return NULL;
        }
        String left = transfer(root.left);
        String right = transfer(root.right);
        return root.val + SEP + left+SEP+right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        for(String s : data.split(",")){
            list.add(s);
        }
        return trans(list);

    }
    public TreeNode trans(LinkedList<String> list){
        if(list.size()==0){
            return null;
        }
        String rootVal = list.removeFirst();
        if(rootVal.equals("null")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        root.left = trans(list);
        root.right = trans(list);
        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

