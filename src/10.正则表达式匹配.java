/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    int m, n;
    public boolean isMatch(String s, String p) {
        m = s.length();
        n = p.length();
        return dp(s, 0, p, 0);
    }
    // s[i...]到p[j...]是否匹配
    public boolean dp(String s, int i, String p, int j){
        if(i == m && j == n){
            return true;
        }
        if(j==n){
            return false;
        }
        if(i==m){ // 如果s到达终点，p剩下的数字是a*b*这种格式，是可以匹配的
            if((n-j) % 2 != 0){
                return false;
            }
            for(int k = j; k < n; k=k+2){
                if(p.charAt(k+1) != '*'){
                    return false;
                }
            }
            return true;
        }
        if(s.charAt(i) == p.charAt(j) || '.' == p.charAt(j)){
            if(j < n-1 && p.charAt(j+1) == '*'){ // p下一个字符是*，可以匹配0次或多次
                return dp(s, i, p, j+2) || dp(s, i+1, p, j);
            }
            return dp(s, i+1, p, j+1); // 普通的一次匹配
        }
        if(s.charAt(i)!= p.charAt(j)){
            if(j < n-1 && p.charAt(j+1) == '*'){
                return dp(s, i, p, j+2);
            }
            return false;
        }
        
        return false;
    }
}
// @lc code=end

