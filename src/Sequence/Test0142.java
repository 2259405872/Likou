package Sequence;

public class Test0142 {
}

class Solution0142_1 {
    public ListNode detectCycle(ListNode head) {
        ListNode l = head,r=head,ans=head;

        while (r!=null&&r.next!=null) {
            l=l.next;
            r=r.next.next;

            if (l==r) break;
        }

        if (r==null||r.next==null) return null;

        while (l!=ans){
            l=l.next;
            ans=ans.next;
        }

        return ans;
    }
}

class Solution0142_2 {
    public ListNode detectCycle(ListNode head) {
        ListNode l = head,r=head;

        while (r!=null&&r.next!=null) {
            l=l.next;
            r=r.next.next;

            if (l==r) break;
        }

        if (r==null||r.next==null) return null;
        l=head;
        while (l!=r){
            l=l.next;
            r=r.next;
        }

        return l;
    }
}