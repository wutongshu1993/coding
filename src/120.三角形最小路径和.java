import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i][j] 以第i行第j列结尾，到第0行的最小路径和
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        int res = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < triangle.get(i).size(); j ++){
                if(j == 0){
                    dp[i][j] = dp[i-1][j]+triangle.get(i).get(j);
                }else if(j == triangle.get(i).size()-1){
                    dp[i][j] = dp[i-1][j-1]+triangle.get(i).get(j);
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j])+triangle.get(i).get(j);
                }
                // System.out.println(""+i+","+j+":"+dp[i][j]);
            }
        }
        for(int i = 0; i < dp[n-1].length; i++){
            res = Math.min(res, dp[n-1][i]);
        }
        return res;
    }
}
// @lc code=end

