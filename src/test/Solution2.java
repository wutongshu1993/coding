/*
 * @lc app=leetcode.cn id=315 lang=java
 *
 * [315] 计算右侧小于当前元素的个数
 */
package test;

import java.util.LinkedList;
import java.util.List;

// @lc code=start
class Solution3 {
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
            if(leftArr[p].val <= rightArr[q].val){
                res[i++] = leftArr[p++];
            }else{
                // System.out.println("a"+leftArr[p].idx);
                count[leftArr[p].idx] += q+1;
                res[i++] = rightArr[q++];
            }
        }
        while(p < leftArr.length){
            // System.out.println("b"+leftArr[p].idx);
            count[leftArr[p].idx] += q;
            res[i++] = leftArr[p++];
        }
        while(q < rightArr.length){
            res[i++] = rightArr[q++];
        }
        for(int idx : count){
            System.out.print(idx);
            System.out.print(",");
        }
        System.out.println();
        return res;
    }

    public static void main(String[] args){
        new test.Solution2().countSmaller(new int[]{5,2,6,1});
    }

    
}
// @lc code=end

