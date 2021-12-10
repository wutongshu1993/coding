package treeNode.bst;

import treeNode.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            // 获取右子树的最小节点.这里也可以获取左子树的最大节点
            TreeNode minNode = GetMin(root.right);
            // 将最小节点放在root的位置；同时删除右子树的最小节点。
            root.right = deleteNode(root.right, minNode.val);
            minNode.left = root.left;
            minNode.right = root.right;
            root= minNode;
        }
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        else if (root.val > key) {
            root.left =  deleteNode(root.left, key);
        }
        return root;
    }

    /**
     * 700. 二叉搜索树中的搜索
     * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }

    /**
     * 获取最小节点
     * @return
     */
    public TreeNode GetMin(TreeNode root) {
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}
