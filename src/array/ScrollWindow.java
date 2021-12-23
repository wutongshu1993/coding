package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ScrollWindow {
    /**
     * https://leetcode-cn.com/problems/minimum-window-substring/
     * 76. 最小覆盖子串
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        HashMap<String, Integer> window = new HashMap<>();
        HashMap<String, Integer> need = new HashMap<>();

        // 构造条件map
        for (int i = 0; i < t.length(); i++) {
            String key = Character.toString(t.charAt(i));
            if (need.containsKey(key)) {
                int val = need.get(key);
                need.put(key, val + 1);
            } else {
                need.put(key, 1);
            }
        }

        int left = 0, right = 0;
        int isValid = 0; // 需要几个数
        int start = 0, minLen = Integer.MAX_VALUE;//最小子串的起始位置和长度
        while (right < s.length()) {
            String c = Character.toString(s.charAt(right));
            right++;
            if (need.containsKey(c)) {
                if (window.containsKey(c)) {
                    window.put(c, window.get(c) + 1);
                } else {
                    window.put(c, 1);
                }

                if (Objects.equals(window.get(c), need.get(c))) {
                    isValid++;
                }
            }
            System.out.printf("window: [%d, %d)\n", left, right);
            // 判读是否要收缩
            while (isValid == need.size()) { // 每个字符个数都满足条件了
                // 更新最小子串信息
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                System.out.printf("window: [%d, %d)\n", left, right);
                String d = Character.toString(s.charAt(left)); // 移出的窗口
                left++;
                if (need.containsKey(d)) {
                    if (Objects.equals(window.get(d), need.get(d))) {
                        isValid--;
                    }
                    window.put(d, window.get(d) - 1);
                }

            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    /**
     * https://leetcode-cn.com/problems/permutation-in-string/
     * 567. 字符串的排列
     * 判断s是否包含t的子排列，t 的排列之一是 s 的 子串
     *
     * @param t
     * @param s
     * @return
     */
    public boolean checkInclusion(String t, String s) {
        HashMap<String, Integer> window = new HashMap<>();
        HashMap<String, Integer> need = new HashMap<>();
        // 构造条件map
        for (int i = 0; i < t.length(); i++) {
            String key = Character.toString(t.charAt(i));
            if (need.containsKey(key)) {
                int val = need.get(key);
                need.put(key, val + 1);
            } else {
                need.put(key, 1);
            }
        }
        int left = 0, right = 0, isValid = 0;
        while (right < s.length()) {
            String key = Character.toString(s.charAt(right));
            right++;
            if (need.containsKey(key)) {
                if (window.containsKey(key)) {
                    window.put(key, window.get(key) + 1);
                } else {
                    window.put(key, 1);
                }
                if (Objects.equals(window.get(key), need.get(key))) {
                    isValid++;
                }
            }


            while (right - left >= t.length()) { // left 需要收缩的条件
                if (isValid == need.size()) {
                    return true;
                }
                String d = Character.toString(s.charAt(left));
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        isValid--;
                    }
                    if (window.containsKey(d)) {
                        window.put(key, window.get(d) - 1);
                    }
                }
            }
        }
        return false;
    }

    /**
     * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
     * 438. 找到字符串中所有字母异位词
     * 找到s中存在的所有t的子排列
     *
     * @param s
     * @param t
     * @return
     */
    public List<Integer> findAnagrams(String s, String t) {
        HashMap<String, Integer> window = new HashMap<>();
        HashMap<String, Integer> need = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        // 构造条件map
        for (int i = 0; i < t.length(); i++) {
            String key = Character.toString(t.charAt(i));
            if (need.containsKey(key)) {
                int val = need.get(key);
                need.put(key, val + 1);
            } else {
                need.put(key, 1);
            }
        }
        int left = 0, right = 0, isValid = 0, startIndex = 0;
        while (right < s.length()) {
            String key = Character.toString(s.charAt(right));
            right++;
            if (need.containsKey(key)) {
                if (window.containsKey(key)) {
                    window.put(key, window.get(key) + 1);
                } else {
                    window.put(key, 1);
                }
                if (window.get(key).equals(need.get(key))) {
                    isValid++;
                }
            }
            while (right - left >= t.length()) { // left 需要收缩的条件
                if (isValid == need.size()) {
                    res.add(left);
                }
                String d = Character.toString(s.charAt(left));
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        isValid--;
                    }
                    window.put(d, window.get(d) - 1);
                }

            }
        }
        return res;
    }

    /**
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
     * 3. 无重复字符的最长子串
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<String, Integer> window = new HashMap<>();
        int max = Integer.MIN_VALUE;

        int left = 0, right = 0;
        while (right < s.length()) {
            String key = Character.toString(s.charAt(right));
            right++;
            System.out.printf("window: [%d, %d)\n", left, right);
            if (window.containsKey(key)) {
                window.put(key, window.get(key) + 1);
            } else {
                window.put(key, 1);
            }
            while (window.get(key) > 1) {
                String d = Character.toString(s.charAt(left));
                window.put(d, window.get(d)-1);
                left++;
            }
            max = Integer.max(right - left, max);
        }
        return max;
    }
}
