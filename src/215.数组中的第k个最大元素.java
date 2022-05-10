import java.util.PriorityQueue;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    public int findKthLargest(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++){
            if(queue.size() < k){
                queue.add(nums[i]);
                continue;
            }
            int min = queue.peek();
            if(min > nums[i]){
                continue;
            }
            queue.poll();
            queue.add(nums[i]);
        }
        return queue.peek();
    }
}
// @lc code=end

