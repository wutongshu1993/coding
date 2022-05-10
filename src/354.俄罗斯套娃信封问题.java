import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=354 lang=java
 *
 * [354] 俄罗斯套娃信封问题
 */

// @lc code=start
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 如果按照宽增序，如果宽相同，则按照高增序
                return o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0];
            }
        });
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for(int i=0; i < envelopes.length; i++){
            if(i > 0){
                for(int j = 0; j < i; j++){
                    if(envelopes[i][1] > envelopes[j][1]){
                       dp[i] = Math.max(dp[j]+1, dp[i]); 
                    }
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
// @lc code=end

