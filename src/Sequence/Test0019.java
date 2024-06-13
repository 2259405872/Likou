package Sequence;

public class Test0019 {
}

class Solution0019_1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0,head),l=pre,r=pre;

        while (n--!=0){
            r=r.next;
        }

        while (r.next!=null){
            r=r.next;
            l=l.next;
        }

        l.next=l.next.next;
        return pre.next;
    }
}

class Solution0019_2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode r = head,l = head;
        for (int i = 0; i < n; i++) r=r.next;

        if (r==null) return head.next;
        while (r.next!=null){
            l=l.next;
            r=r.next;
        }

        l.next=l.next.next;
        return head;
    }
}

class Solution0019_3 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = new ListNode(0,head);
        ListNode l=ans,r=ans;
        for (int i = 0; i < n; i++) r=r.next;

        while (r.next!=null){
            l=l.next;
            r=r.next;
        }
        l.next=l.next.next;

        return ans.next;
    }
}