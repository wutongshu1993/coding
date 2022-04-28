import java.util.Stack;
/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> t = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i = temperatures.length-1; i >=0 ; i--){
            while(!t.empty() && temperatures[i] >= temperatures[t.peek()]){
                t.pop();
            }
            res[i] = t.empty() ? 0 : (t.peek()-i);
            t.push(i);
        }
        return res;
    }
}
// @lc code=end

