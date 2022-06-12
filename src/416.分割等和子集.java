/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        sum = sum / 2;

        // dp[i][j] 能否只使用前i个数，凑成j值（将背包装满）,i 从1开始计数
        boolean[][] dp = new boolean[nums.length+1][sum+1];
        for(int i = 0; i <= nums.length; i++){
            for(int j = 0; j <= sum; j++){
                if(i==0){
                    dp[0][j] = false;
                    continue;
                }
                if(j == 0){
                    dp[i][0] = true;
                    continue;
                }
                if(j - nums[i-1] < 0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] ||  dp[i-1][j-nums[i-1]];
                }
                
            }
        }
        return dp[nums.length][sum];
    }
    
}
// @lc code=end

