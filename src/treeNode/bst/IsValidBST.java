package treeNode.bst;

import treeNode.TreeNode;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
    public boolean isValid(TreeNode root, TreeNode maxTreeNode, TreeNode minTreeNode){
        if(root == null){
            return true;
        }
        if(minTreeNode != null && root.val < minTreeNode.val){
            return false;
        }
        if(maxTreeNode != null && root.val > maxTreeNode.val){
            return false;
        }
        return isValid(root.left, root, minTreeNode) && isValid(root.right, maxTreeNode, root);

    }
}
