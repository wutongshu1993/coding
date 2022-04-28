/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */

import java.util.HashMap;
import java.util.Stack;

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> h = new HashMap<>();
        Stack<Integer> s= new Stack<>();
        int[] res = new int[nums1.length];
        for(int i = nums2.length-1; i >=0; i--){
            while(!s.empty() && nums2[i] > s.peek()){
                s.pop();
            }
            h.put(nums2[i], s.empty()?-1:s.peek());
            s.push(nums2[i]);
        }
        for(int i =0; i < nums1.length; i++){
            res[i] = h.get(nums1[i]);
        }
        return  res;
    }
}
// @lc code=end

