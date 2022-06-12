import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        // dp[i][0] nums[0...i]以nums[i]结尾的乘积最大子数组
        // dp[i][1] nums[0...i]以nums[i]结尾的乘积最小子数组
        int[][] dp = new int[n][2];
        // for(int i = 0; i < n; i++){
        //     dp[i][0] = 1;
        //     dp[i][1] = -1;
        // }
        if(nums[0] < 0){
            dp[0][1] = nums[0];
        }else{
            dp[0][0] = nums[0];
        }
        System.out.println("0:"+0+" "+dp[0][0]+","+dp[0][1]);
        
        for(int i = 1; i < n; i++){
            if(nums[i]>0){
                if(dp[i-1][0] != 0){
                    dp[i][0] = dp[i-1][0] * nums[i];     
                }else{
                    dp[i][0] = nums[i];
                }
                if(dp[i-1][1] != 0){
                    dp[i][1]= dp[i-1][1] * nums[i];
                }
                res = Math.max(dp[i][0], res);
                
            }else{
                if(dp[i-1][0] != 0){
                    dp[i][1] = dp[i-1][0]*nums[i];
                }else{
                    dp[i][1] = nums[i];
                }
                if(dp[i-1][1] != 0){
                    dp[i][0] = dp[i-1][1]*nums[i];
                }
                res = Math.max(dp[i][0], res);
            }
            System.out.println("i:"+i+" "+dp[i][0]+","+dp[i][1]);
        }
        return res;
    }
}
// @lc code=end

