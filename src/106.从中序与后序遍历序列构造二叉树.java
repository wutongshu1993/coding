/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight){
        if(inLeft > inRight || postLeft > postRight){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postRight]);
        int inRootIdx = 0;
        for(int i= inLeft; i <=inRight; i++){
            if(inorder[i] == postorder[postRight]){
                inRootIdx = i;
            }
        }
        int leftLen = inRootIdx - inLeft;
        root.left = build(inorder, postorder, inLeft, inRootIdx-1, postLeft, postLeft+leftLen-1);
        root.right = build(inorder, postorder, inRootIdx+1, inRight, postLeft+leftLen, postRight-1);
        return root;
    }
}
// @lc code=end

