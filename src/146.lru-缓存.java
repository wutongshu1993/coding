import java.util.LinkedHashMap;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start
class LRUCache {
    // 使用cache存储，最近使用过的放在队尾
    LinkedHashMap<Integer, Integer> cache;
    int size = 0;
    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>();
        this.size = capacity;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        // 将元素变为最近使用过的,重新插入到队尾
        makeRecently(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){//已经存在，修改值，放到队尾
            cache.remove(key);
            cache.put(key, value);
            makeRecently(key);
            return;
        }
        if(cache.size()<size){
            cache.put(key, value);//直接放到队尾
            return;
        }
        // 队头元素最老
        int oldKey = cache.keySet().iterator().next();
        cache.remove(oldKey);
        cache.put(key, value);//直接放到队尾
    }

    private void makeRecently(int key){
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

