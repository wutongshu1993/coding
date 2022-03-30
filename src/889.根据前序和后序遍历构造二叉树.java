/*
 * @lc app=leetcode.cn id=889 lang=java
 *
 * [889] 根据前序和后序遍历构造二叉树
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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, postorder, 0, preorder.length-1, 0, postorder.length-1);
    }
    public TreeNode build(int[] preorder, int[] postorder, int preLeft, int preRight, int postLeft, int postRight){
        if(preRight < preLeft || postRight < postLeft){
            return null;
        }
        if(preLeft==preRight){
            return new TreeNode(preorder[preLeft]);
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int leftRootVal = preorder[preLeft+1];// 将前序遍历的第二个节点当作左子树的根结点
        int postLeftRootIdx = 0;
        for(int i = postLeft; i <= postRight; i++ ){
            if(postorder[i] == leftRootVal){
                postLeftRootIdx = i;
                break;
            }
        }
        int leftLen = postLeftRootIdx-postLeft+1;
        root.left = build(preorder, postorder, preLeft+1, preLeft+leftLen, postLeft, postLeft+leftLen-1);
        root.right = build(preorder, postorder, preLeft+leftLen+1, preRight, postLeft+leftLen, postRight-1);
        return root;
    }
}
// @lc code=end

