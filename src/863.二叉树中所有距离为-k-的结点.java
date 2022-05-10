import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=863 lang=java
 *
 * [863] 二叉树中所有距离为 K 的结点
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<Integer, TreeNode> parent = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        traverse(root, null);
        Queue<TreeNode> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(target);
        visited.add(target.val);
        int step = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i = 0; i < sz; i++){
                TreeNode cur = q.poll();
                if(step == k){
                    res.add(cur.val);
                    continue;
                }
                // 处理cur相邻的，包括左右子树和父节点
                if(cur.left!=null && !visited.contains(cur.left.val)){
                    q.add(cur.left);
                    visited.add(cur.left.val);
                }
                if(cur.right!=null && !visited.contains(cur.right.val)){
                    q.add(cur.right);
                    visited.add(cur.right.val);
                }
                if(parent.get(cur.val)!=null && !visited.contains(parent.get(cur.val).val)){
                    q.add(parent.get(cur.val));
                    visited.add(parent.get(cur.val).val);
                }
            }
            step++;
        }
        return res;
    }
    public void traverse(TreeNode node, TreeNode p){
        if(node == null){
            return;
        }
        parent.put(node.val, p);
        traverse(node.left, node);
        traverse(node.right, node);
    }
}
// @lc code=end

