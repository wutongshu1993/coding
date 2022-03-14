/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return traverse(nums, 0, nums.length -1);
    }
    public TreeNode traverse(int[] nums, int left, int right) {
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = 0;
        // base case
        if(left > right){
            return null;
        }
        for(int i = left; i <= right; i++){
            if(nums[i] > maxValue){
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = traverse(nums, left, maxIndex-1);
        root.right = traverse(nums, maxIndex+1, right);
        return root;
    }
}
// @lc code=end

