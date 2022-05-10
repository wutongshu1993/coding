import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            LinkedList<Integer> t = new LinkedList<>();
            for(int i = 0; i < sz; i++){
                TreeNode cur = q.poll();
                if(cur.left != null){
                    q.addLast(cur.left);
                }
                if(cur.right != null){
                    q.addLast(cur.right);
                }
                if(level % 2 == 0){
                    t.addLast(cur.val);  
               }else{
                   t.addFirst(cur.val);
               }
            }
            level++;
            res.add(t);
        }
        return res;
    }
}
// @lc code=end

