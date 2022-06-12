import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=718 lang=java
 *
 * [718] 最长重复子数组
 */

// @lc code=start
class Solution {
    int[][] memo;
    int res = 0;
    public int findLength2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        memo = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(memo[i], -1);
        }
        dp(nums1, nums2, m-1, n-1);
        return res;
    }
    // dp[i][j] nums1[0...i] 与 nums2[0...j]的最长公共子数组 这样的定义适合子序列，不适合子串
    // dp[i][j] 以i和j结尾的，nums1[0...i] 与 nums2[0...j]的最长公共子数组
    public int dp(int[] nums1, int[] nums2, int i, int j){
        if(i == 0 ){
            return nums1[0] == nums2[j] ? 1: 0;
        }
        if(j == 0 ){
            return  nums1[i] == nums2[0] ? 1: 0;
        }
        // if(memo[i][j] != -1){
        //     return memo[i][j];
        // }
        if(nums1[i] == nums2[j]){
            return 1+dp(nums1, nums2, i-1, j-1);
        }
        memo[i][j] = 0;
        res = Math.max(res, Math.max(dp(nums1, nums2, i, j-1), dp(nums1, nums2, i-1, j)));
        return 0;
    }
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // dp[i][j] 以nums1[i] 和 nums2[j] 结尾的最长重复子数组的长度
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            if(nums1[i] == nums2[0]){
                dp[i][0] = 1;
                res = Math.max(dp[i][0], res);
            }
        }
        for(int j = 0; j < n; j++){
            if(nums1[0] == nums2[j]){
                dp[0][j] = 1;
                res = Math.max(dp[0][j], res);
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(nums1[i] == nums2[j]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    res = Math.max(dp[i][j], res);
               }
            }
        }
        return res;
    }
}
// @lc code=end

