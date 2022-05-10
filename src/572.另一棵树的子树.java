import treeNode.TreeNode;

/*
 * @lc app=leetcode.cn id=572 lang=java
 *
 * [572] 另一棵树的子树
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
    public boolean isSubtree1(TreeNode root, TreeNode subRoot) {
        String s1 = traverse(root);
        String s2 = traverse(subRoot);
        System.out.println(s1);
        System.out.println(s2);
        return s1.indexOf(s2)==-1 ? false: true;
    }
    public String traverse(TreeNode root){
        if(root==null){
            return "null";
        }
        StringBuffer sb = new StringBuffer();
        sb.append(",");
        sb.append(root.val);
        sb.append(",");
        sb.append(traverse(root.left));
        sb.append(",");
        sb.append(traverse(root.right));
        sb.append(",");
        return sb.toString();
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
       if(subRoot==null){
        return true;
       }
       if(root==null){
        return false;
       }
       return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)||isSameTree(root, subRoot);
    }
    public boolean isSameTree(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot==null){
            return true;
        }
        if(root==null){
            return false;
        }
        if(subRoot==null){
            return false;
        }
        if(root.val!=subRoot.val){
            return false;
        }
        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);

        
    }
}
// @lc code=end

