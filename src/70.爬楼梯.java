/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        // dp[i] 总共有i阶，有多少种方式到达i，i从0开始计数
        int[] dp = new int[n];
        dp[0] = 1;
        if(n > 1){
            dp[1] = 2;
        }
        for(int i = 2; i< n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
}
// @lc code=end

