import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=931 lang=java
 *
 * [931] 下降路径最小和
 */

// @lc code=start
class Solution {
    int[][] memo;
    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        int n = matrix.length;
        memo = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(memo[i], 99999);
        }
        // 最后一行的每一列都可能在最小路径中
        for(int j = 0; j < n; j++){
            res = Math.min(res, dp(matrix, n-1, j));
        }
        return res;

    }
    // 到达matrix[i][j]的最小路径
    public int dp(int[][] matrix, int i, int j){
        // 先处理越界问题
        if(i<0 || j < 0 || i>=matrix.length || j >= matrix.length){
            return 10001;
        }
        // 再处理base case
        if(i==0){
            return matrix[i][j];
        }
        if(memo[i][j] != 99999){
            return memo[i][j];
        }
        memo[i][j] = matrix[i][j]+Math.min(Math.min(dp(matrix, i-1, j-1), dp(matrix, i-1, j+1)), dp(matrix, i-1, j));
        // 最后处理转移方程
        return memo[i][j];
    }
}
// @lc code=end

