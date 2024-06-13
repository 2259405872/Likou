package Sequence;

public class Test0206 {
}

class Solution0206_1 {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;

        ListNode temp = head;
        ListNode now = head.next;
        temp.next=null;

        while (now!=null){
            ListNode next = now.next;
            now.next=temp;
            temp=now;
            now=next;
        }

        return temp;
    }
}

class Solution0206_2 {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode pre = head,now = head.next;
        head.next=null;

        while(now!=null){
            ListNode temp = now.next;
            now.next=pre;
            pre=now;
            now=temp;
        }

        return pre;
    }
}