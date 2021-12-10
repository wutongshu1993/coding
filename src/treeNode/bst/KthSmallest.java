package treeNode.bst;

import treeNode.TreeNode;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * 230. 二叉搜索树中第K小的元素
 */
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }
    int rank;
    int res;
    public void traverse(TreeNode root, int k){
        if(root == null){
            return;
        }
        traverse(root.left, k);
        rank++;
        if(rank == k){
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
