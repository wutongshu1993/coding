/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        //dp[i][0]/dp[i][1] 表示第i天 不拥有/拥有 股票的最大收益 
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1;i < n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]-fee);// 卖的时候收手续费
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);//可以做多次交易
        }
        return dp[n-1][0];
    }
}
// @lc code=end

