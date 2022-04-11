/*
 * @lc app=leetcode.cn id=315 lang=java
 *
 * [315] 计算右侧小于当前元素的个数
 */

import java.util.LinkedList;
import java.util.List;

// @lc code=start
class Solution {
    class Pair{
        int val;
        int idx;
        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }

    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        count = new int[nums.length];
        Pair[] arr = new Pair[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[i] = new Pair(nums[i], i);
        }
        sort(arr, 0, nums.length-1);
        List<Integer> res = new LinkedList<>();
        for(int c : count){
            res.add(c);
        }
        return  res;
    }

    public Pair[] sort(Pair[] arr, int low, int high){
        if(low > high){
            return null;
        }
        if(low==high){
            return new Pair[]{arr[low]};
        }
        int mid = low + (high-low)/2;
        Pair[] leftArr = sort(arr, low, mid);
        Pair[] rightArr = sort(arr, mid+1, high);
        return merge(leftArr, rightArr);
    }

    public Pair[] merge(Pair[] leftArr, Pair[] rightArr){
        Pair[] res = new Pair[leftArr.length+rightArr.length];
        int p=0, q=0, i=0;
        while(p < leftArr.length && q < rightArr.length){
            if(leftArr[p].val < rightArr[q].val){
                count[leftArr[p].idx] += q-1;
                res[i++] = leftArr[p++];
            }else{
                res[i++] = rightArr[q++];
            }
        }
        while(p < leftArr.length){
            count[leftArr[p].idx] += q-1;
            res[i++] = leftArr[p++];
        }
        while(q < rightArr.length){
            res[i++] = rightArr[q++];
        }
        return res;
    }

}
// @lc code=end

