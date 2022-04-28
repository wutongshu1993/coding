import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i < k-1){
                window.push(nums[i]);
            }else{
                window.push(nums[i]);
                list.add(window.max());
                window.pop(nums[i-k+1]);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
    // 单调队列
    class MonotonicQueue{
        LinkedList<Integer> q = new LinkedList<>();
        public void push(int n){
            while(!q.isEmpty() && n > q.getLast()){
                q.pollLast();
            }
            q.addLast(n);
        }
        public void pop(int n){
            if(q.getFirst() == n){
                q.removeFirst();
            }
        }
        public int max(){
            return q.getFirst();
        }
    }
}
// @lc code=end

