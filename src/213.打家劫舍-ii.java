/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        // dp[i]偷前i家最多可以偷多少钱, i从1开始计数
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        return Math.max(robRange(nums,1, n-1), robRange(nums, 2, n));
    }

    // 从start到end，start从1开始计数
    public int robRange(int[] nums, int start, int end){
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[start] = nums[start-1];
        for(int i = start+1; i <= end; i++){
            dp[i] = Math.max(dp[i-1] , dp[i-2]+nums[i-1]); 
        }
        return dp[end];
    }
}
// @lc code=end

