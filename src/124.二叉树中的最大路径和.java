import treeNode.TreeNode;

/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        oneSideMax(root);
        return res;
    }
    // 以root为根节点的最大单边路径和
    int oneSideMax(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftMax = Math.max(0,oneSideMax(root.left));
        int rightMax = Math.max(0,oneSideMax(root.right));
        int pathMax = root.val + leftMax+rightMax;
        // System.out.println(root.val+":"+pathMax);
        res = Math.max(res, pathMax);
        return root.val+Math.max(leftMax, rightMax);
    }
}
// @lc code=end

