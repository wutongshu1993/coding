import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    int[]  memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = wordDict.size();
        // dp[i] s[i...]能否被字典中词拼出来
        memo = new int[s.length()];
        Arrays.fill(memo, -1);

        return dp(s, 0, wordDict);
    }
    // s[i...]能否被字典中词拼出来
    boolean dp(String s, int i, List<String> wordDict){
        if(i == s.length()){
            return true;
        }
        if(memo[i] != -1){
            return memo[i] == 1?true:false;
        }
        for(String word : wordDict){
            int len = word.length();
            if(i+len > s.length()){
                continue;
            }
            String subStr = s.substring(i, i+len);
            if(!subStr.equals(word)){
                continue;
            }
            // 下面这里很关键，只能是成功了才返回。如果不成功就进行下一个选择。
            if(dp(s, i+len, wordDict)){
                memo[i] = 1;
                return true;
            }
        }
        memo[i] = 0;
        return false;
    }
}
// @lc code=end

