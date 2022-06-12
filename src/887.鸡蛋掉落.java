import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=887 lang=java
 *
 * [887] 鸡蛋掉落
 */

// @lc code=start
class Solution {
    int[][] memo;
    public int superEggDrop(int k, int n) {
        memo = new int[k+1][n+1];
        for(int i = 0; i < k+1; i++){
        Arrays.fill(memo[i], -1);
       }
        return dp(k, n);
    }
    // k个鸡蛋，n层楼，最坏至少需要的次数
    public int dp(int k, int n){
        if(k == 1){
            return n;
        }
        if(n == 1){
            return 1;
        }
        if(n == 0){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        if(memo[k][n] != -1){
            return memo[k][n];
        }
        int low = 1, high = n;
        while(low <= high){ // 需要用二分法来优化
            int mid = (high+low)/2;
            int not_broken = dp(k, n-mid);// mid 没碎
            int broken = dp(k-1, mid-1);//mid 碎了
            if(not_broken > broken){
                low = mid +1;
                res = Math.min(res, not_broken+1);
            }else{
                high = mid -1;
                res = Math.min(res, broken+1);
            }
        }
        // for(int i = 1; i < n+1; i++){
        //     res = Math.min(res, Math.max(dp(k, n-i), dp(k-1, i-1))+1);
        // }
        memo[k][n] = res;
        return res;
    }
}
// @lc code=end

