package Sequence;

public class Test0086 {
}

class Solution0086_1 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode l=new ListNode(),temp1=l,r=new ListNode(),temp2=r,current=head;
        while(current!=null){
            ListNode temp=current.next;

            if(current.val<x){
                temp1.next=current;
                current.next=null;
                temp1=current;
            }else {
                temp2.next=current;
                current.next=null;
                temp2=current;
            }

            current=temp;
        }
        temp1.next=r.next;
        return l.next;
    }
}