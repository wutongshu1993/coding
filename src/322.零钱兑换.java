/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    int[] memo;
    public int coinChange2(int[] coins, int amount) {
        memo = new int[amount+1];
        Arrays.fill(memo, -666);
        return dp(coins, amount);
    }

    public int dp(int []coins, int amount){
        if(amount==0){
            return 0;
        }
        if(amount<0){
            return -1;
        }
        if(memo[amount] != -666){
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for(int coin : coins){
            int subRes = dp(coins, amount-coin);
            if(subRes == -1){
                continue;
            }
            res = Math.min(res, subRes+1);
        }
        res = res==Integer.MAX_VALUE?-1:res;
        memo[amount] = res;
        return res;
    }

    public int coinChange(int[] coins, int amount) {
        //dp[i] 定义amount为i需要多少个硬币
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i=1; i < dp.length; i++){
            for(int coin : coins){
                if(i-coin < 0){
                    continue;
                }
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }

        return dp[amount]==amount+1 ? -1:dp[amount];
    }

}
// @lc code=end

