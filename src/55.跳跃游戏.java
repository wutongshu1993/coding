/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        // 每个位置能到达的最远距离（位置下标从0开始计数），如果最远距离大于n-1，则能到达最后一个
        int farthest = 0;
       for(int i = 0; i < n-1; i++){
        // 避免到达不了i的情况
        if(farthest < i){
            return false;
        }
        farthest = Math.max(farthest, i+nums[i]);
       }
       if(farthest >= n-1){
            return true;
       }
        return false;
    }
}
// @lc code=end

