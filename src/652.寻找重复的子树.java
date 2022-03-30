/*
 * @lc app=leetcode.cn id=652 lang=java
 *
 * [652] 寻找重复的子树
 */

// @lc code=start

// import treeNode.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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
    List<TreeNode> res = new LinkedList<>();
    HashMap<String, Integer> memo = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        trans(root);
        return res;
    }
    public String trans(TreeNode root){
        if(root == null){
            return "#";
        }
        String left = trans(root.left);
        String right = trans(root.right);
        String str = left+","+right+","+root.val;
        int times = memo.getOrDefault(str, 0);
        if(times == 1){
            res.add(root);
        }
        memo.put(str, times+1);
        return str;
    }
}
// @lc code=end

