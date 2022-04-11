/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        return sort(nums, 0, nums.length-1);
    }
    public int[] sort(int[] arr, int low, int high){
        if(low > high){
            return null;
        }
        if(high==low){
            return new int[]{arr[low]};
        }
        int mid = low + (high-low)/2;
        int[] leftArr = sort(arr, low, mid);
        int[] rightArr = sort(arr, mid+1, high);
        return merge(leftArr, rightArr);
    }

    public int[] merge(int[] leftArr, int[] rightArr){
        int[] res = new int[leftArr.length+rightArr.length];
        int p =0, q = 0, i= 0;
        while(p < leftArr.length && q < rightArr.length){
            if(leftArr[p] <= rightArr[q]){
                res[i++]=leftArr[p++];
            }else{
                res[i++]=rightArr[q++];
            }
        }
        while(p < leftArr.length){
            res[i++] = leftArr[p++];
        }
        while(q < rightArr.length){
            res[i++] = rightArr[q++];
        }
        return res;
    }
}
// @lc code=end

