import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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
    List<List<Integer>>  res = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum, new LinkedList<>());
        return res;
    }
    public void traverse(TreeNode root, int targetSum, LinkedList<Integer> path){
        if(root == null){
            return;
        }
        if(root.left == null &&root.right==null){
            if( targetSum == root.val){
                path.add(root.val);
                res.add(new LinkedList<>(path));
                path.removeLast();
            }
            return;
        }
        
        path.addLast(root.val);
        traverse(root.left, targetSum-root.val, path);
        path.removeLast();

        path.addLast(root.val);
        traverse(root.right, targetSum-root.val, path); 
        path.removeLast();

    }
}
// @lc code=end

