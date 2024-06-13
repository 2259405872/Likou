package Sequence;

public class Test0082 {
}

class Solution0082_1 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre=new ListNode(),result=pre,current=head;

        while(current!=null){
            if(current.next!=null&&current.val==current.next.val){
                current=next(current);
                continue;
            }

            pre.next=current;
            pre=current;
            current=current.next;
            pre.next=null;
        }

        return result.next;
    }

    public static ListNode next(ListNode head) {
        int val = head.val;
        while (head!=null ){
            if (head.val!=val){
                break;
            }
            head=head.next;
        }
        return head;
    }
}