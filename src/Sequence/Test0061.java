package Sequence;

public class Test0061 {
    public static void main(String[] args) {
        new Solution0061_1().rotateRight(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5))))),2);
    }
}
class Solution0061_1 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k==0||head==null) return head;

        int len=1,count;
        ListNode current = head,tail,result;

        while(current.next!=null) {
            len++;
            current=current.next;
        }
        count=k%len;
        if (count==0) return head;

        tail=current;
        current=new ListNode(0,head);


        while(count<=--len){
            current=current.next;
        }
        result=current.next;
        current.next=null;
        tail.next=head;

        return result;
    }
}