package Sequence;

public class Test0025 {
}

class Solution0025_1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode(0,head),pre=result,tail=head,current=result;
        int count=0;
        while (current!=null) {
            if (count==k){
                tail=current;
                current=current.next;
                tail.next=null;

                pre.next= reverse(head);

                pre=head;

                head=current;
                count=1;
                continue;
            }

            current=current.next;
            count++;
        }

        pre.next=head;
        return result.next;
    }

    public static ListNode reverse(ListNode head){
        ListNode result = head,current=head;

        while (current!=null) {
            ListNode temp=current.next;
            current.next=result;
            result=current;
            current=temp;
        }

        return result;
    }
}

class Solution0025_2 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ans = new ListNode(0,head),pre=ans;
        while (head!=null) {
            ListNode now = pre;
            for (int i = 0; i < k; i++) {
                if (now.next==null) return ans.next;
                now=now.next;
            }

            ListNode temp = now.next;
            now.next=null;
            pre.next=reverse(head);

            pre=head;
            head.next=temp;
            head=temp;
        }

        return ans.next;
    }

    public ListNode reverse(ListNode head){
        ListNode temp = null;
        while (head.next!=null) {
            ListNode next = head.next;

            head.next=temp;

            temp=head;
            head=next;
        }

        head.next=temp;
        return head;
    }
}