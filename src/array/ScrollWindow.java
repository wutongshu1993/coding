package array;

import java.util.HashMap;
import java.util.Objects;

public class ScrollWindow {
    /**
     * https://leetcode-cn.com/problems/minimum-window-substring/
     * 76. 最小覆盖子串
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        HashMap<String, Integer> window = new HashMap<>();
        HashMap<String, Integer> need = new HashMap<>();

        // 构造条件map
        for(int i = 0; i < t.length(); i++){
            String key = Character.toString(t.charAt(i));
            if(need.containsKey(key)){
                int val = need.get(key);
                need.put(key, val+1);
            }else{
                need.put(key, 1);
            }
        }

        int left =0, right = 0;
        int isValid  = 0; // 需要几个数
        int start = 0, minLen = Integer.MAX_VALUE;//最小子串的起始位置和长度
        while(right < s.length()){
            String c = Character.toString(s.charAt(right));
            right++;
            if(need.containsKey(c)){
                if(window.containsKey(c)){
                    window.put(c, window.get(c)+1);
                }else{
                    window.put(c, 1);
                }

                if(Objects.equals(window.get(c), need.get(c))){
                    isValid++;
                }
            }
            System.out.printf("window: [%d, %d)\n", left, right);
            // 判读是否要收缩
            while(isValid == need.size()){ // 每个字符个数都满足条件了
                // 更新最小子串信息
                if(right - left < minLen){
                    minLen = right - left;
                    start = left;
                }
                System.out.printf("window: [%d, %d)\n", left, right);
                String d = Character.toString(s.charAt(left)); // 移出的窗口
                left++;
                if (need.containsKey(d)){
                    if(Objects.equals(window.get(d), need.get(d))){
                        isValid--;
                    }
                    window.put(d, window.get(d)-1);
                }

            }
        }
        return  minLen == Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);
    }
}
