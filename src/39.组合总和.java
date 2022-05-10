import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, target, 0);
        return res;
    }
    public void backtrack(int[] candidates, int start, int target, int sum){
        if(sum == target){
            res.add(new LinkedList<>(track));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(sum+candidates[i] > target){
                continue;
            }
            sum += candidates[i];
            track.add(candidates[i]);
            backtrack(candidates, i, target, sum);
            track.removeLast();
            sum -= candidates[i];
        }
    }
}
// @lc code=end

