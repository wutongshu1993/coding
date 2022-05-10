import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 */

// @lc code=start
class Solution {
    int m, n;
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        m = text1.length();
        n = text2.length();
        memo = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(memo[i], -1);
        }
        return dp(text1, 0, text2, 0);
    }
    // 返回s1[i...]和s2[j...]的最达公共子序列
    public int dp(String s1, int i, String s2, int j){
        // base case
        if(i == m || j == n){
            return 0;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return 1+dp(s1, i+1, s2, j+1);
        }
        memo[i][j] = Math.max(dp(s1, i+1, s2,j), dp(s1, i, s2,j+1));
        return memo[i][j] ;
    }
}
// @lc code=end

