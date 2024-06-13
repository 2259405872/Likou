package Sequence;

public class TestX_0207 {
}

class Solution_0207X_1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        int lengthA = 0,lengthB = 0;
        ListNode tempA = headA,tempB = headB;
        while (tempA != null||tempB != null) {
            if (tempA != null){
                tempA = tempA.next;
                lengthA++;
            }
            if (tempB != null){
                tempB = tempB.next;
                lengthB++;
            }
        }

        if (lengthA < lengthB) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;

            int t=lengthA;
            lengthA=lengthB;
            lengthB=t;
        }

        int count = lengthA - lengthB;

        while (count-- > 0) headA = headA.next;

        while (headB != null&&headA!=null){
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}
