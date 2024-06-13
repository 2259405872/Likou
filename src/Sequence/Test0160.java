package Sequence;

public class Test0160 {
    public static void main(String[] args){
        new Solution0160_1().getIntersectionNode(
                new ListNode(4,new ListNode(1,new ListNode(8,new ListNode(4,new ListNode(5))))),
                new ListNode(5,new ListNode(6,new ListNode(1,new ListNode(8,new ListNode(4,new ListNode(5))))))
        );
    }
}

class Solution0160_1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ans=null;
        ListNode headA1 = headA;
        while (headA1!=null){
            ListNode temp = headA1.next;
            headA1.val=-headA1.val;
            headA1= temp;
        }

        ListNode headB1 = headB;
        while (headB1!=null){
            ListNode temp = headB1.next;
            if (headB1.val<0) {
                ans=headB1;
                break;
            }
            headB1=temp;
        }

        headA1 = headA;
        while (headA1!=null){
            ListNode temp = headA1.next;
            headA1.val=-headA1.val;
            headA1= temp;
        }

        return ans;
    }


}
