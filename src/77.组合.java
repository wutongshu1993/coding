import java.util.LinkedList;
import java.util.List;
/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution77 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, 1, k);
        return res;
    }
    public void backtrack(int n, int start, int k){
        if(track.size() == k){
            res.add(new LinkedList<>(track));
            return;
        }
        for(int i = start; i < n+1; i++){
            track.addLast(i);
            backtrack(n, i+1, k);
            track.removeLast();
        }
    }
}
// @lc code=end

