package treeNode;


/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 236. 二叉树的最近公共祖先
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root == p || root == q){ // 以 p 或者 q 为 root， LCA 当然是 p 或 q
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left !=  null && right != null){ // 后续遍历，从下往上走，第一次相交的节点就是 LCA
            return root;
        }
        if(left == null && right == null){
            return null;
        }
        return left == null ? right : left;
    }
}
