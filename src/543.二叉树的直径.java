/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
 */

// @lc code=start

// import treeNode.TreeNode;
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
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }
    int maxDiameter = 0;
    public int maxDepth(TreeNode root){
       if(root==null){
            return 0;
       }
       int leftHeight = maxDepth(root.left);
       int rightHeight = maxDepth(root.right);
       int myDiameter = leftHeight+rightHeight;
       maxDiameter = Math.max(maxDiameter, myDiameter);

       return 1+ Math.max(leftHeight, rightHeight);
       
    }
}
// @lc code=end

