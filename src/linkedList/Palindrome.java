package linkedList;

public class Palindrome {
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    public boolean traverse(ListNode right){
        if(right == null){
            return true;
        }
        boolean res = traverse(right.next);
        res = res && right.val == left.val;
        left = left.next;
        return res;
    }
}
