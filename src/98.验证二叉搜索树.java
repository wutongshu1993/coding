import treeNode.TreeNode;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        traverse(root, null, null);
        return isValid;
    }
    public void traverse(TreeNode root, TreeNode max, TreeNode min){
        if(root == null){
            return;
        }
        if(max != null && root.val >= max.val){
            isValid = false;
        }
        if(min != null && root.val <= min.val){
            isValid = false;
        }
        traverse(root.left, root, min);
        traverse(root.right, max, root);
    }
}
// @lc code=end

