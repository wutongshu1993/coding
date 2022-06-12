import treeNode.TreeNode;

/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    boolean isExisited = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum);
        return isExisited;
    }
    public void traverse(TreeNode root, int targetSum){
        if(root == null){
            return;
        }
        if(root.left == null &&root.right==null && targetSum == root.val){
            isExisited = true;
            return;
        }
        
        if(!isExisited){
            traverse(root.left, targetSum-root.val);
            traverse(root.right, targetSum-root.val);
        }   
    }
}
// @lc code=end

