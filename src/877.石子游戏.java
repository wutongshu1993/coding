/*
 * @lc app=leetcode.cn id=877 lang=java
 *
 * [877] 石子游戏
 */

// @lc code=start
class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        // dp[i][j][0]表示从第i堆（i从0开始计数）到第j堆，先手拿的最大值
        // dp[i][j][1]表示从第i堆（i从0开始计数）到第j堆，后手拿的最大值
        // 转移方程：dp[i][j][0] = max(piles[i]+dp[i+1][j][1], pile[j]+dp[i][j-1][1])
        // 如果先手拿了左边的：dp[i][j][1] = dp[i+1][j][0]
        // 如果先手拿了右边的：dp[i][j][1] = dp[i][j-1][0]
        int[][][] dp = new int[n][n][2];
        for(int i = 0; i < n; i++){
            dp[i][i][0] = piles[i];
            dp[i][i][1] = 0;
        }
        // 从右下，斜着遍历
        for(int i = n-2; i >= 0; i--){
            for(int j = i+1; j <n; j++){
                int left = piles[i]+dp[i+1][j][1];
                int right =  piles[j]+dp[i][j-1][1];
                if(left > right){
                    dp[i][j][0] = left;
                    dp[i][j][1] = dp[i+1][j][0];
                }
                else{
                    dp[i][j][0] = right;
                    dp[i][j][1] = dp[i][j-1][0];
                }
            }
        }
        return dp[0][n-1][0] > dp[0][n-1][1]; 
    }
}
// @lc code=end

