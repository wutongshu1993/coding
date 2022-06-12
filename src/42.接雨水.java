import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        if(height.length == 0){
            return 0;
        }
        int n = height.length;
        int res = 0;
        int[] leftArrays = new int[n];
        leftArrays[0] = height[0];
        int[] rightArrays = new int[n];
        rightArrays[n-1]= height[n-1];
        for(int i = 1; i < n; i++){
            leftArrays[i] = Math.max(height[i], leftArrays[i-1]);
        }
        for(int i = n-2; i >= 0; i--){
            rightArrays[i] = Math.max(height[i], rightArrays[i+1]);
        }
        for(int i = 0; i < n; i++){
            int left_max = leftArrays[i];
            int right_max = rightArrays[i];
            int real_height =  Math.min(left_max, right_max);
            if(height[i] < real_height){
                res += real_height-height[i];
            } 
        }
        return res;
    }
}
// @lc code=end

