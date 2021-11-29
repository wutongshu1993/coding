package linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLinkedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> pr = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        for(int i = 0; i < lists.length; i++){
            ListNode p = lists[i];
            if(p != null){
                pr.add(p);
            }
        }
        ListNode dumy = new ListNode(-1);
        ListNode newHead = dumy;
        while(!pr.isEmpty()){
            ListNode head = pr.poll();
            newHead.next = head;
            newHead = newHead.next;
            if(head.next != null) {
                pr.add(head.next);
            }

        }

        return dumy.next;
    }
}
