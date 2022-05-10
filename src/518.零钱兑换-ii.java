import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length+1;
        // dp[i][j]定义为使用coins的前i（从1开始计数）个硬币，凑到j，有dp[i][j]种解法
        int[][] dp = new int[n][amount+1];
        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < amount+1; j++){
                if(j - coins[i-1] < 0){//第i个硬币放进来，超过了amount对应的值
                    dp[i][j] = dp[i-1][j];
                }else{
                    // 把coin[i]放入 // 不把coin[i]放入
                    dp[i][j] = dp[i][j-coins[i-1]]+ dp[i-1][j];
                }
            }
        }
        return dp[n-1][amount];
    }
}
// @lc code=end

