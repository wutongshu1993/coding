package array;

/**
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * 560. 和为 K 的子数组
 */
public class SubarraySum {
    int[] preSum;
    public int subarraySum(int[] nums, int k) {
        preSum = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++){
           preSum[i] = nums[i-1]+preSum[i-1];
        }
        for(int i = 0; i < preSum.length){

        }
    }
}
