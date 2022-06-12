/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        // dp[i][j] 以[i,j]为右下角的最大正方形的边长
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;
                max = Math.max(max, dp[i][0]);
            }
        }
        for(int j = 0; j < n; j++){
            if(matrix[0][j] == '1'){
                dp[0][j] = 1;
                max = Math.max(max, dp[0][j]);
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1])+1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
// @lc code=end

