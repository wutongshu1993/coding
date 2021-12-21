package array.presum;

/**
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * 560. 和为 K 的子数组
 */
public class SubarraySum {
    int[] preSum;
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        preSum = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++){
           preSum[i] = nums[i-1]+preSum[i-1];
        }
        for(int i = 1; i < preSum.length;i++){
            for(int j = 0; j < i; j++){
                if(preSum[i]-preSum[j]==k){
                    res+=1;
                }
            }
        }
        return res;
    }
}
