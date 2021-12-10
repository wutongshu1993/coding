package treeNode.bst;

import treeNode.TreeNode;

/**
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * 538. 把二叉搜索树转换为累加树
 */
public class ConvertBST {
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    int sum;

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }
}
