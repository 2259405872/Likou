package Sequence;

public class Test0203 {
}

class Solution203_1 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode ans = new ListNode(0, head),pre = ans;


        while (head != null) {
            if (head.val == val) pre.next = head.next;
            else pre = head;
            head = head.next;

        }

        return ans.next;
    }
}
