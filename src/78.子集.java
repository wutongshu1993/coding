import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution78 {
    List<List<Integer>> res = new LinkedList();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }
    // 数组中元素不同，不能重复使用
    public void backtrack(int[]nums, int start){
        res.add(new LinkedList<>(track));
        for(int i = start; i < nums.length; i++){
            track.addLast(nums[i]);
            backtrack(nums, i+1);
            track.removeLast();
        }
    }
}
// @lc code=end

