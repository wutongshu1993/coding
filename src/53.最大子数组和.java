/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length];
        for(int i = 0;i < nums.length; i++){
            dp[i] = nums[i];
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(i>0){
                dp[i] = Math.max(dp[i], dp[i-1]+nums[i]);
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
// @lc code=end

