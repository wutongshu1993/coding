package array;

/**
 * 差分数组工具类
 */
public class Difference {
    private int[] diff;

    /**
     * 输入一个数组，构造这个数组的差分数组
     * @param nums
     */
    public  Difference(int[] nums){
        diff = new int[nums.length];
        diff[0] = nums[0];
        for(int i = 1; i< nums.length; i++){
            diff[i] = nums[i]-diff[i-1];
        }
    }

    /**
     * 给闭区间[i,j]中的每个数增加 val,注意这里增加是对nums增加，而不是对diff增加
     * @param i
     * @param j
     */
    public void increment(int i, int j, int val){
        diff[i] += val;
        if(j+1 < diff.length){
            diff[j+1] -= val;
        }
    }

    public int[] result(){
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for(int i = 1; i < diff.length; i++){
            res[i] = res[i-1] + diff[i];
        }
        return res;
    }


    /**
     * https://leetcode-cn.com/problems/range-addition/
     *  370 题「区间加法」
     * @param length
     * @param updates
     * @return
     */
    int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        new Difference(nums);
        for(int i = 0; i < updates.length; i++){
            int from = updates[i][0];
            int end = updates[i][1];
            int val = updates[i][2];
            increment(from, end, val);
        }
        return result();
    }

    /**
     * https://leetcode-cn.com/problems/corporate-flight-bookings/
     * 1109. 航班预订统计
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference diff = new Difference(nums);
        for(int i = 0; i < bookings.length; i++){
            int from = bookings[i][0]-1;
            int end = bookings[i][1]-1;
            int val = bookings[i][2];
            diff.increment(from, end, val);
        }
        return diff.result();
    }


    /**
     *https://leetcode-cn.com/problems/car-pooling/
     * 1094. 拼车
     * @param trips
     * @param capacity
     * @return
     */
    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1001];
        Difference diff = new Difference(nums);
        for(int i = 0; i < trips.length; i++){
            int from = trips[i][1];
            int end = trips[i][2]-1; // 这一站已经下车了，所以需要-1
            int val = trips[i][0];
            diff.increment(from, end, val);
        }
        int[] res = diff.result();
        for(int i = 0; i < res.length; i++){
            if(res[i] > capacity){
                return false;
            }
        }
        return true;
    }

    /**
     * https://leetcode-cn.com/problems/split-array-largest-sum/
     * 410. 分割数组的最大值
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        return 0;
    }
}
