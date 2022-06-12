import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=662 lang=java
 *
 * [662] 二叉树最大宽度
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
    // 记录节点和对应编号
    class Pair {
        TreeNode node;
        int id;

        public Pair( TreeNode node, int id) {
            this.node = node;
            this.id = id;
        }
    }
    int max = 0;
    public int widthOfBinaryTree(TreeNode root) {
        traverse(root);
        return max;
    }
    public void traverse(TreeNode root){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 1));
        while(!q.isEmpty()){
            int sz = q.size();
            int start =0;
            int end = 0;
            for(int i = 0 ; i < sz; i++){
                Pair cur = q.poll();
                TreeNode curNode = cur.node;
                int curId = cur.id;
                // 因为q中放的是非空的节点数据，所以这里可以直接取第0个和最后一个代表边界
                if(i == 0){
                    start = curId;
                }
                if(i == sz-1){
                    end = curId;
                }
                if(curNode.left != null){
                    q.add(new Pair(curNode.left, curId*2));
                }
                if(curNode.right != null){
                    q.add(new Pair(curNode.right, curId*2+1));
                }

            }
            max = Math.max(max, end-start+1);
        }
    }
}
// @lc code=end

