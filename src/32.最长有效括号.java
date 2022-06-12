import java.util.Stack;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        // 计算s[i-1]结尾的最长合法字符的大小
        int res = 0;
        int[] dp = new int[s.length()+1];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(i);
                dp[i+1] = 0;
                continue;
            }
            if(!st.isEmpty()){
                int leftIndex = st.pop();
                dp[i+1] = i-leftIndex+1+dp[leftIndex];              
                res = Math.max(res, dp[i+1]);
            }else{
                dp[i+1] = 0;
            }
        }
        return res;
    }
}
// @lc code=end

