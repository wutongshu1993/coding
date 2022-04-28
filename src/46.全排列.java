import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }
    public void backtrack(int[] nums, LinkedList<Integer> track){
        if(track.size() == nums.length){
            res.add(new LinkedList<>(track));//注意这里要拷贝一份新的
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if (track.contains(nums[i])){
                continue;
            }
            track.addLast(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }
}
// @lc code=end

