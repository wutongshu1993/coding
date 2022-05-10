import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=712 lang=java
 *
 * [712] 两个字符串的最小ASCII删除和
 */

// @lc code=start
class Solution {
    int m, n;
    int[][] memo;
    public int minimumDeleteSum(String s1, String s2) {
        m = s1.length();
        n = s2.length();
        memo = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(memo[i], -1);
        }
        return dp(s1, 0, s2, 0);
    }
    // 返回s1[i...]和s2[j...]这两个字符串相等所需删除字符的 ASCII 值的最小和
    public int dp(String s1, int i, String s2, int j){
        int res = 0;
        if(i == m){
            for(int k = j; k < n; k++){
                res += s2.charAt(k);
            }
            return res;
        }
        if(j == n){
            for(int k = i; k < m; k++){
                res += s1.charAt(k);
            }
            return res;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return dp(s1, i+1, s2, j+1);
        }
        memo[i][j] = Math.min(s1.charAt(i)+dp(s1, i+1, s2, j),s2.charAt(j)+dp(s1, i, s2, j+1));
        return memo[i][j];
    }
}
// @lc code=end

