package linkedList;

public class DetectCircle {
    /**
     * 找出环形链表的环起点。
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        boolean hasCircle = false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                hasCircle = true;
                break;
            }
        }
        if(!hasCircle){
           return null;
        }
        slow = head;
        while(slow != fast){
           slow = slow.next;
           fast = fast.next;
        }
        return slow;
    }
}
