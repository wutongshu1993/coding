import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution90 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 遇到数组中有重复元素的子集问题，先排序
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }
    public void backtrack(int nums[], int start){
        res.add(new LinkedList<>(track));
        for(int i = start; i < nums.length; i++){
            // 遇到第二个重复元素，不处理;重点在于i>start
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            track.addLast(nums[i]);
            backtrack(nums, i+1);
            track.removeLast();
        }
    }
}
// @lc code=end

