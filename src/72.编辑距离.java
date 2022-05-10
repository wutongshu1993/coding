import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        memo = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(memo[i], 1000);
        }
       
        return dp(word1, m-1, word2, n-1);
    }

    // s1[0...i]到s2[0...j]的最小编辑距离
    public int dp(String s1, int i, String s2, int j){
        if(i==-1){// s1为空，s1要到s2只能是全部新增操作
            return j+1;
        }
        if(j==-1){ // s2为空，s1要到s2只能是全部删除操作
            return i+1;
        }
        if(memo[i][j] != 1000){
            return memo[i][j];
        }
        // i,j相等，不需要操作，都向前移动
        if(s1.charAt(i)==s2.charAt(j)){
            return dp(s1, i-1, s2, j-1);
        }
        memo[i][j] = Math.min(Math.min(
            dp(s1, i, s2, j-1)+1,  // s1新增
            dp(s1, i-1, s2, j)+1), // s1 删除
            dp(s1, i-1, s2, j-1)+1);
        return memo[i][j];
    }
}
// @lc code=end

