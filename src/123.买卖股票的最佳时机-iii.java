/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //dp[i][k][0]/dp[i][k][1] 表示第i天 不拥有/拥有 股票的最大收益,k代表第i天的最大交易次数的上限
        int k = 2;
        int[][][] dp = new int[n][k+1][2];
        for(int i = 0;i < n; i++){
            for(int j = k; j >0; j--){
                if(i == 0){
                    dp[i][j][0] = 0;
                    dp[i][j][1] =-prices[i];  
                    continue; 
                }
                // if(j==0){
                //     dp[i][j][0] = 0;
                //     dp[i][j][1] =Integer.MIN_VALUE;     
                // }
                
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1]+prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0]-prices[i]);
                //今天的组大交易次数是k，且今天要交易，所以昨天的最大交易次数是k-1
            }
        }

        return dp[n-1][k][0];
    }
}
// @lc code=end

