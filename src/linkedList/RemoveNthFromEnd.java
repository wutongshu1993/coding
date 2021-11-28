package linkedList;

public class RemoveNthFromEnd {
    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head, p2 = head;
        int i = 1;
        while(i < k ){
            p2 = p2.next;
            i++;
        }
        while(p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        // 使用虚拟头节点，n+1，实际上也是虚拟头节点的倒数低n+1个，这里只是为了防止越界
        ListNode pre = findFromEnd(dumy, n+1);
        pre.next = pre.next.next;
        return dumy.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);


        new RemoveNthFromEnd().removeNthFromEnd(l1, 5);
    }
}
