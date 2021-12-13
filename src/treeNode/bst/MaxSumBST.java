package treeNode.bst;

import treeNode.TreeNode;

/**
 * 1373. 二叉搜索子树的最大键值和
 * https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree/
 */
public class MaxSumBST {
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return max;
    }

    int max = Integer.MIN_VALUE;

    /**
     * @param root
     * @return 返回数组，
     * res[0] 是否为bst
     * res[1]: 最小值
     * res[2]: 最大值
     * res[3]: 和
     */
    public int[] traverse(TreeNode root) {
        if (root == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] res = new int[4];
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);
        if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]) {
            res[0] = 1;
            res[1] = Integer.min(root.val, left[1]);
            res[2] = Integer.max(root.val, right[2]);
            res[3] = root.val + left[3] + right[3];
            max = Integer.max(res[3], max);
        } else {
            res[0] = 0;
            return res;
        }
        return res;
    }
}
