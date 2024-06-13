package Sequence;

public class Test0024 {
}

class Solution0024_1 {
    public ListNode swapPairs(ListNode head) {
        ListNode ans = new ListNode(0, head),now=ans;

        while (now.next!=null&&now.next.next!=null) {
            ListNode temp = now.next;
            now.next = temp.next;
            temp.next=temp.next.next;
            now.next.next=temp;

            now=temp;
        }

        return ans.next;
    }
}

class Solution0024_2 {
    public ListNode swapPairs(ListNode head) {
        ListNode ans = new ListNode(0, head),now=ans;
        while (now.next!=null&&now.next.next!=null) {
            ListNode temp = now.next;
            now.next = temp.next;

            temp.next=temp.next.next;
            now.next.next=temp;
            now=temp;
        }

        return ans.next;
    }
}