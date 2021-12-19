package array;

/**
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 * 区域和检索 - 数组不可变
 */
public class NumArray {
    int[] preSum;

    public NumArray(int[] nums) {
        preSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                preSum[i] = nums[i];
                continue;
            }
            preSum[i] = preSum[i - 1] + nums[i];
            System.out.println(preSum[i]);
        }

    }

    public int sumRange(int left, int right) {
        if(left==0){
            return preSum[right];
        }
        return preSum[right]-preSum[left-1];
    }
}
