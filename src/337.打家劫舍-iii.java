import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import treeNode.TreeNode;

/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
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
    HashMap<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(memo.containsKey(root)){
            return memo.get(root);
        }
        int do_it = root.val +
         (root.left==null?0:rob(root.left.left)+rob(root.left.right))+
        (root.right==null?0:rob(root.right.left)+rob(root.right.right));
        int not_do = rob(root.left)+rob(root.right);
        memo.put(root,  Math.max(do_it, not_do));
        return memo.get(root);
    }   
}
// @lc code=end

