import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        // dp[i]到达该位置至少需要几跳
        int[] dp = new int[n];
        // farthest[i]i位置，最远能到达的下标
        int[] farthest = new int[n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for(int i = 0; i < n-1; i++){
            farthest[i] = i+nums[i];
        }
        for(int i = 1; i < n; i++){
            for(int j = i-1; j >=0; j--){
                if(farthest[j] >= i){
                    dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }
        }
        
        return dp[n-1];
    }
}
// @lc code=end

