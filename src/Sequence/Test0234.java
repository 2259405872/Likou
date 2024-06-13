package Sequence;

public class Test0234 {
    public static void main(String[] args) {
        new Solution0234_1().isPalindrome(new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(1)))));
    }
}

class Solution0234_1 {
    public boolean isPalindrome(ListNode head) {
        if(head.next==null) return true;
        ListNode left = head, right = head;

        while (right.next.next != null) {
            left=left.next;
            right=right.next.next;
            if(right.next==null) break;
        }

        right=left.next;
        left.next=null;
        left=head;
        right=reverse(right);

        while (right!=null) {
            if (right.val!=left.val) return false;

            right=right.next;
            left=left.next;
        }

        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = head;
        ListNode now = head.next;
        pre.next=null;

        while (now != null) {
            ListNode temp = now.next;
            now.next=pre;
            pre=now;
            now=temp;
        }

        return pre;
    }
}
