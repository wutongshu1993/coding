/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

// @lc code=start

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
    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMiddle(head);
        ListNode newHead = reverse(mid);
        
        while(newHead != null){
            if (head.val == newHead.val){
                head = head.next;
                newHead = newHead.next;
            }else{
                return false;
            }
        }
        return true;
    }
    public ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        return slow;
    }

    // 反转以slow为起点的链表
    public ListNode reverse(ListNode head){
        ListNode pre=null, cur= head, next=head;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
// @lc code=end

