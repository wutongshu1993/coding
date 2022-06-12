/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for(int i= 0; i < s.length(); i++){
            String a = palindrome(s, i, i);
            String b = palindrome(s, i, i+1);
            if(a.length() > res.length()){
                res = a;
            }
            if(b.length() > res.length()){
                res = b;
            }
        }
        return res;
    }
    // 以s[i],s[j]为中心的最大回文子串
    public String palindrome(String s, int i, int j){
        while(i >=0 && j <s.length()){
            if(s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }else{
                return s.substring(i+1, j);
            }
        }
        return s.substring(i+1, j);
    }
}
// @lc code=end

