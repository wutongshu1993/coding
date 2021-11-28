package linkedList;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 判断两个链表是否相交
 */
public class GetIntersectionNode{
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 != p2){
            if(p1 == null){
                p1 = headB;
            }else {
                p1 = p1.next;
            }

            if(p2 == null){
                p2 = headA;
            }else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}
