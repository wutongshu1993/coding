package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * https://leetcode-cn.com/problems/random-pick-with-blacklist/
 * 710. 黑名单中的随机数
 */
public class BlackList {
    int sz;
    Map<Integer, Integer> map = new HashMap<>();
    Random rand = new Random();
    public BlackList(int n, int[] blacklist){
        sz = n - blacklist.length;
        int last = n-1;
        for(int b : blacklist){
            map.put(b, 666);// 赋一个初始值
        }
        for(int b : blacklist){
            if(b >= sz){// 黑名单数据在末尾，不用处理
                continue;
            }
            while(map.containsKey(last)){
                last--;
            }
            map.put(b, last);
            last--;
        }
    }

    public int pick() {
        int r = rand.nextInt(sz);
        if(map.containsKey(r)){
            return map.get(r);
        }
        return r;
    }
}
