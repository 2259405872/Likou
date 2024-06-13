package Sequence;

public class Test0148 {
    public static void main(String[] args) {
        new Solution0148_1().sortList(new ListNode(4,
                new ListNode(2,new ListNode(1,
                        new ListNode(3)))
                ));
    }
}

class Solution0148_1 {
    int[]values;
    public ListNode sortList(ListNode head) {
        if (head ==null) return null;

        ListNode temp=head;
        int count=0;
        while (temp!=null) {
            count++;
            temp=temp.next;
        }


        temp=head;
        this.values=new int[count];
        for (int i = 0; i < count; i++,temp=temp.next) {
            values[i]=temp.val;
        }

        return merge(0,count-1);
    }

    public ListNode merge(int start, int end) {
        if (start==end) return new ListNode(values[start]);
        int mid = (start + end) / 2;

        ListNode left = merge(start, mid);
        ListNode right = merge(mid + 1, end);

        return shor(left, right);
    }

    public ListNode shor(ListNode left, ListNode right) {
        ListNode result=new ListNode();
        ListNode temp=result;

        while (left!=null&&right!=null){
            int val1 = left.val;
            int val2 = right.val;
            if (val1<val2){
                temp.next=left;
                left=left.next;
            }else {
                temp.next=right;
                right=right.next;
            }
            temp=temp.next;
        }

        temp.next=left==null?right:left;

        return result.next;
    }

}

class Solution0148_2 {
    public ListNode sortList(ListNode head) {
        int length = 0;

        for (ListNode now=head;now!=null;now=now.next) length++;

        return merge(head, length);
    }

    public ListNode merge(ListNode head,int length) {
        if (length<=1) return head;

        int count = length / 2;
        ListNode node = head;
        for (int i = 1; i < count; i++) node=node.next;

        ListNode temp = node.next;
        node.next=null;

        ListNode left = merge(head, count);
        ListNode right = merge(temp, length - count);

        return sort(left,right);
    }

    public ListNode sort(ListNode left,ListNode right){
        ListNode result=new ListNode();
        ListNode temp=result;

        while (left!=null&&right!=null){
            int val1 = left.val;
            int val2 = right.val;
            if (val1<val2){
                temp.next=left;
                left=left.next;
            }else {
                temp.next=right;
                right=right.next;
            }
            temp=temp.next;
        }

        temp.next=left==null?right:left;

        return result.next;
    }
}