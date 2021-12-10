package treeNode.bst;

import treeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * 95. 不同的二叉搜索树 II
 */
public class GenerateTrees {
    List<TreeNode>[][] memo;

    public List<TreeNode> generateTrees(int n) {
        memo = new ArrayList[n + 1][n + 1];
        return build(1, n);

    }

    public List<TreeNode> build(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start >= end) {
            res.add(null);
            return null;
        }
        if (memo[start][end] != null) {
            return memo[start][end];
        }

        for (int i = start; i < end; i++) {
            List<TreeNode> left = build(start, i - 1);
            List<TreeNode> right = build(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        memo[start][end] = res;
        return res;
    }
}
