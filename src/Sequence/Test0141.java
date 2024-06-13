package Sequence;

public class Test0141 {
}
class Solution0141_1 {
    public boolean hasCycle(ListNode head) {
        ListNode l=head;
        ListNode r=head;

        while (r!=null&&r.next!=null) {
            l=l.next;
            r=r.next.next;
            if (r==l) return true;
        }
        return false;
    }
}

class Solution0141_2 {
    public boolean hasCycle(ListNode head) {
        if(head.next==null) return false;
        ListNode left = head, right = head;

        while (right.next.next != null) {
            left=left.next;
            right=right.next.next;

            if (left==right) return true;
            if(right.next==null) return false;
        }
        return false;
    }
}
