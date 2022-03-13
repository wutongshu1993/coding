/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start

// import linkedList.ListNode;

import linkedList.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * 翻转[a,b)内的
     * @param a
     * @param b
     * @return
     */
    public ListNode reverse(ListNode a, ListNode b){
        ListNode cur=a, pre=null, next=a;
        while(cur != b){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a=head, b=head;
        for(int i = 0; i<k; i++){
            if(b==null){
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        ListNode next = reverseKGroup(b, k);
        head.next = next;
        return newHead;
    }
}
// @lc code=end

