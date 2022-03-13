package array;

import java.text.SimpleDateFormat;
import java.util.*;

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

    public static void main(String[] args){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        date = calendar.getTime();
        System.out.println(sdf.format(date));
    }
}
