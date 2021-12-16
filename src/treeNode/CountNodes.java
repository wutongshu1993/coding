package treeNode;

/**
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * 222. 完全二叉树的节点个数
 * 完全二叉树可能不是满二叉树，满二叉树是完全二叉树
 */
public class CountNodes {
    public int countNodes(TreeNode root) {
        TreeNode r = root, l = root;
        int leftHeight = 0;
        int rightHeight = 0;
        while (l != null) {
            l = l.left;
            leftHeight++;
        }

        while (r != null) {
            r = r.right;
            rightHeight++;
        }

        if (leftHeight == rightHeight) {// 满二叉树
            return (int) (Math.pow(2, leftHeight) - 1);
        }

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return 1 + leftCount + rightCount;
    }
}
