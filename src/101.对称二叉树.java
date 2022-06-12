import treeNode.TreeNode;

/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
    public boolean isSymmetric(TreeNode root) {
        return traverse(root.left, root.right);
    }
    public boolean traverse(TreeNode tree1, TreeNode tree2){
        if(tree1 == null && tree2 == null){
            return true;
        }
        if(tree1==null || tree2 == null){
            return false;
        }
        if(tree1.val != tree2.val){
            return false;
        }
        return traverse(tree1.left, tree2.right) &&traverse(tree1.right, tree2.left);

    }
}
// @lc code=end

