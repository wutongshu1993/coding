import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0, j = 0;// i, j 分别指向左右窗口[i,j)
        int n = s.length();
        int res = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        while(j < n){
            // 窗口不含该字符，则放入窗口，右指针右移
            if(!window.containsKey(s.charAt(j))){
                window.put(s.charAt(j), 1);
                j++;
            }else{
                // 窗口包含该字符，左指针右移
                window.remove(s.charAt(i));
                i++;
            }
            // 不断更新结果
            res = Math.max(res, window.size());
        }
        return res;
    }
}
// @lc code=end

