package array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AdvantageCount {
    /**
     * https://leetcode-cn.com/problems/advantage-shuffle/
     * 870. 优势洗牌
     * 让nums1[i]的元素尽可能比nums2[i]的元素大
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        // 将nums1 升序排列；但nums2不能改变
        Arrays.sort(nums1);
        // nums2 中的元素降序排列，使用优先级队列辅助（不能更改nums2中元素的顺序）
        PriorityQueue<int[]> maxpq = new PriorityQueue<>((int[] pair1, int[] pair2) -> {
            return pair2[1] - pair1[1];
        });
        int n = nums2.length;
        for (int i = 0; i < n; i++) {
            maxpq.offer(new int[]{i, nums2[i]});
        }
        int left = 0, right = n - 1;
        int[] res = new int[n];
        while (!maxpq.isEmpty()){ // 或者left <= right
            int[] pair = maxpq.poll();
            int index = pair[0], maxVal = pair[1];
            if(nums1[right] > maxVal){ // 自己上（最大值）
                res[index] = nums1[right];
                right--;
            }else{ // 最小值上，炮灰
                res[index] = nums1[left];
                left++;
            }
        }
        return res;
    }
}
