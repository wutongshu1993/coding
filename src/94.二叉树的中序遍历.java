import java.util.LinkedList;
import java.util.List;

import treeNode.TreeNode;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root==null){
            return res;
        }
        List<Integer> left = inorderTraversal(root.left);
        if(left != null){
            res.addAll(left);
        }
        res.add(root.val);
        List<Integer> right = inorderTraversal(root.right);
        if(right != null){
            res.addAll(right);
        }
       
        return res;
    }
}
// @lc code=end

