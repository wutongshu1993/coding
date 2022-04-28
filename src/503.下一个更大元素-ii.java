/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 */

import java.util.Stack;

// @lc code=start
class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        for(int i = nums.length*2-1; i >= 0; i--){
            while(!s.isEmpty() && nums[i%nums.length] >= s.peek()){
                s.pop();
            }
            res[i%nums.length] = s.empty()? -1: s.peek();
            s.push(nums[i%nums.length]);
        }
        return res;
    }
}
// @lc code=end

