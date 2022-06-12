import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p.val, q.val);

    }
    public TreeNode find(TreeNode root, int pVal, int qVal){
        if(root==null){
            return null;
        }
        if(root.val == pVal || root.val == qVal){
            return root;
        }
        TreeNode left = find(root.left, pVal, qVal);
        TreeNode right = find(root.right, pVal, qVal);
        if(left != null && right != null){
            return root;
        }
        return left==null ? right:left;
    }
}
// @lc code=end

