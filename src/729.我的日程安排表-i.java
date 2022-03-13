/*
 * @lc app=leetcode.cn id=729 lang=java
 *
 * [729] 我的日程安排表 I
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class MyCalendar {
    List<int[]> res = new ArrayList<>();
    public MyCalendar() {

    }
    
    public boolean book(int start, int end) {
        for(int i = 0; i < res.size(); i++){
            if(res.get(i).length==2){
                if(start<=res.get(i)[0] && end >res.get(i)[0]){
                    return false;
                }
                if(start>=res.get(i)[0] && end <=res.get(i)[1]){
                    return false;
                }
                if(start<res.get(i)[1] && end >res.get(i)[1]){
                    return false;
                }
            }
        }
        res.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end

