/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
    int res = 0;
    int depth = 0;

//    public int maxDepth(TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//        int leftHeight = maxDepth(root.left);
//        int rightHeight = maxDepth(root.right);
//        return Math.max(leftHeight, rightHeight) +1;
//    }
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) +1;
    }
    public void travers(TreeNode root){
        if(root == null){
            res = Math.max(res, depth);
            return;
        }
        depth++;
        travers(root.left);
        travers(root.right);
        depth--;
    }
}
// @lc code=end

