import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import treeNode.TreeNode;

/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
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
    List<Integer> res = new ArrayList<>();
    int depth = 0;
    public List<Integer> rightSideView2(TreeNode root) {
        traverse(root);
        return res;
    }
    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        depth++;
        if(res.size() < depth){
            res.add(root.val);
        }
        traverse(root.right);
        traverse(root.left);
        depth--;
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode last = q.peek();
            int sz = q.size();
            for(int i = 0; i < sz; i++){
                TreeNode cur = q.poll();
                if(cur.right != null){
                    q.offer(cur.right);
                }
                if(cur.left != null){
                    q.offer(cur.left);
                }
            }
            res.add(last.val);
        }
        return res;
    }
}
// @lc code=end

