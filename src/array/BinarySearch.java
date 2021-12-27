package array;

public class BinarySearch {
    /**
     * https://leetcode-cn.com/problems/koko-eating-bananas/
     * 875. 爱吃香蕉的珂珂
     *
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1000000000 + 1;// 注意：left 和 right 对应最大速度和最小速度
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (fEat(piles, mid) < h) { // 需要让函数返回值更大一些，减小速度，也即收缩右边界
                right = mid;
            } else if (fEat(piles, mid) == h) { // 需要左边界
                right = mid;
            } else if (fEat(piles, mid) > h) { // 需要函数返回值更小一些，即增大速度，收缩左边界
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 以速度为x吃香蕉，需要多少时间；速度和时间呈单调递减关系
     *
     * @param piles
     * @param x     吃香蕉的速度
     * @return
     */
    public int fEat(int[] piles, int x) {
        int hour = 0;
        for (int i = 0; i < piles.length; i++) {
            hour += piles[i] / x;
            if (piles[i] % x > 0) {
                hour++;
            }
        }
        return hour;
    }


    /**
     * https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
     * 1011. 在 D 天内送达包裹的能力
     *
     * @param weights
     * @param days
     * @return
     */
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }
        int left = max, right = sum + 1; // 最小航运能力是货物中最重的包裹（需要保证能运走一个包裹）； 最大航运能力即一次运完所有包裹
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (fShip(weights, mid) < days) {
                right = mid;
            } else if (fShip(weights, mid) == days) {
                right = mid;
            } else if (fShip(weights, mid) > days) {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 航运能力为x时，运送完所有包裹需要的时间
     *
     * @param weights
     * @param x
     * @return
     */
    public int fShip(int[] weights, int x) {
        int d = 0;

        for (int i = 0; i < weights.length; ) {
            int cap = x;
            while (i < weights.length) {
                if (cap < weights[i]) {
                    break;
                } else {
                    cap -= weights[i];
                    i++;
                }
            }
            d++;
        }
        return d;
    }
}
