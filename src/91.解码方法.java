/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        // dp[i] s[0...i]解码方式
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        // i 和dp数组有1个偏移
        for(int i = 2; i < n+1; i++){
            if(s.charAt(i-1) >= '1' && s.charAt(i-1) <= '9'){
                dp[i] = dp[i-1];
            }
            if(s.charAt(i-2) == '1' || s.charAt(i-2) == '2' && s.charAt(i-1) <= '6'){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];

    }
}
// @lc code=end

