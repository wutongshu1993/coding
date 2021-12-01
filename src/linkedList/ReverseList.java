package linkedList;

public class ReverseList {
    /**
     * 反转所有链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 反转链表前n个节点，比如 1->2->3->4->5, 3; 结果3->2->1->4->5
     *
     * @param head
     * @param n
     * @return
     */
    ListNode successor = null; // 后驱节点

    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode newHead = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return newHead;
    }

    /**
     * 反转 left 到 right 之间的节点
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        ListNode h1 = reverseBetween(head.next, left - 1, right - 1);
        head.next = h1;
        return head;
    }

    /**
     * 递归实现反转整个链表
     * @param head
     * @return
     */
    public ListNode reverse2(ListNode head) {
        ListNode cur = head, nxt = head, pre = null;
        while(cur != null){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    /**
     * 反转 [a, b) 之间的元素
     *
     * @param a
     * @param b
     * @return
     */
    public ListNode reverse(ListNode a, ListNode b) {
        ListNode cur = a, nxt = a, pre = null;
        while(cur != b){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    /**
     * k 个一组翻转链表
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[2,1,4,3,5]
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b != null) {
                b = b.next;
            }else{
                return head;
            }
        }
        // 反转前 K 个元素
        ListNode newHead = reverse(a, b);
        // k个一组，递归反转剩余元素
        ListNode h2 = reverseKGroup(b, k);

        head.next = h2;

        return newHead;
    }
}
