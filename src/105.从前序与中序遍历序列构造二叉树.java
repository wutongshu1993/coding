/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight){
        if(preLeft > preRight || inLeft > inRight){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int inRootIdx = 0;
        for(int i= inLeft; i <=inRight; i++){
            if(inorder[i] == preorder[preLeft]){
                inRootIdx = i;
            }
        }
        int leftLen = inRootIdx - inLeft;
        root.left = build(preorder, inorder, preLeft+1, preLeft+leftLen, inLeft, inRootIdx-1);
        root.right = build(preorder, inorder, preLeft+leftLen+1, preRight, inRootIdx+1, inRight);
        return root;
    }
}
// @lc code=end

