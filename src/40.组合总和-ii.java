import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution40 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, 0, target);
        return res;
    }

    public void backtrack(int[] nums, int start,int sum, int target){
        if(sum == target){
            res.add(new LinkedList<>(track));
            return;
        }
        for(int i = start; i < nums.length; i++){
            if(sum > target){
                continue;
            }
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }
            track.addLast(nums[i]);
            sum += nums[i];
            backtrack(nums, i+1, sum, target);
            sum -= nums[i];
            track.removeLast();
        }
    }


}
// @lc code=end

