package Sequence;

public class Test0092 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(3, new ListNode(5));
        new Solution0092_1().reverseBetween(listNode,1,2);
    }
}

class Solution0092_1 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode current = head,newL=null,newR=null,front=null,result=head;
        int count = 1;
        while (count<=right){
            if (count==left-1){
                front=current;
            }

            if (count==left){
                newR=current;
                newL=current;
            }

            ListNode temp=current;
            current = current.next;

            if(count>left){
                temp.next=newL;
                newL=temp;
            }

            count++;
        }

        if (front != null) {
            front.next=newL;
        }else {
            result=newL;
        }
        newR.next=current;

        return result;
    }
}