import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    int[][] memo;
    public int numTrees(int n) {
        memo = new int[n+1][n+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(memo[i], -1);
        }
        return dp(1, n);
    }
    // i~j 的二叉平衡数的种数
    public int dp(int low, int high){
        if(low > high){
            return 0;
        }
        if(low == high){
            return 1;
        }
        if(memo[low][high] != -1){
            return memo[low][high];
        }
        int res = 0;
        for(int i = low; i <= high; i++){
            // 以 i 为根节点
            int left = dp(low, i-1);
            int right = dp(i+1,high);
            if(left != 0 && right != 0){
                res += left * right;
            }else{
                res += left == 0 ? right : left;
            }
        }
        memo[low][high] = res;
        System.out.println(""+low+","+high+":"+res);
        return res;
    }
}
// @lc code=end

