import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    LinkedList<TreeNode> q = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        q.addLast(root);
        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> t = new LinkedList<>();
            for(int i = 0; i < sz; i++){
                TreeNode cur = q.poll();
                if(cur == null){
                    continue;
                }
                t.add(cur.val);
                q.addLast(cur.left);
                q.addLast(cur.right); 
            }
            if(t.size()>0){
                res.add(t);
            }
            
        }
        return res;
    }
}
// @lc code=end

