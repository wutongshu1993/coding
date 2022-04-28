/*
 * @lc app=leetcode.cn id=698 lang=java
 *
 * [698] 划分为k个相等的子集
 */

// @lc code=start
class Solution698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(k > nums.length){
            return false;
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % k != 0){
            return false;
        }
        int target = sum / k;
        boolean[] used = new boolean[nums.length];
        return backtrack(k, 0, nums, used, 0, target);
    }
    // 以桶的视角 k:第k个桶，bucket:当前桶装的值，used:nums中的数字的使用情况, start: 开始位置
    public boolean backtrack(int k, int bucket, int[] nums, boolean[] used, int start, int target){
        if(k == 0){
            return true;
        }
        if(bucket==target){// 当前桶装满了,装下一个桶
            return backtrack(k-1, 0, nums, used, 0, target);
        }
        for(int i = start; i < nums.length; i++){
            if(used[i]){// 该数字已经在其他桶用过了
                continue;
            }
            if(bucket + nums[i] > target){
                continue;
            }
            // 可以放进去
            bucket += nums[i];
            used[i] = true;
            // 递归穷举下一个数是否要加入当前桶
            if(backtrack(k, bucket, nums, used, i+1, target)){
                return true;
            };
            // 回溯
            bucket -= nums[i];
            used[i] = false;
        }
        return false;
    }
}
// @lc code=end

