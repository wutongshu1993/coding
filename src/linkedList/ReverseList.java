package linkedList;

public class ReverseList {
    /**
     * 反转所有链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 反转链表前n个节点，比如 1->2->3->4->5, 3; 结果3->2->1->4->5
     * @param head
     * @param n
     * @return
     */
    ListNode successor = null; // 后驱节点
    public ListNode reverseN(ListNode head, int n) {
        if(n == 1){
            successor = head.next;
            return head;
        }
        ListNode newHead = reverseN(head.next, n-1);
        head.next.next = head;
        head.next = successor;
        return newHead;
    }
}
