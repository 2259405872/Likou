package Sequence;

public class Test0002 {
}

/*
class N {
    int val;
    N next;
    N() {}
    N(int val) {
        this.val = val;
    }
    N(int val, N next) {
        this.val = val;
        this.next = next;
    }
}*/



class Solution0002_00 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode solution = new ListNode((l1.val+l2.val)%10);
        ListNode next=solution;
        int remainder=(l1.val+l2.val)/10;
        while (true) {
            int m = 0,n=0;
            if (l1!=null){
                l1=l1.next;
                if (l1!=null) {
                    m = l1.val;
                }
            }
            if (l2!=null){
                l2=l2.next;
                if (l2!=null) {
                    n = l2.val;
                }
            }

            if(l1==null&&l2==null){
                if (remainder!=0){
                    next.next=new ListNode(remainder);
                }
                break;
            }

            next.next=new ListNode((m+n+remainder)%10);
            remainder=(m+n+remainder)/10;
            next=next.next;
        }
        return solution;
    }
}

class Solution0002_second {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum=l1.val+l2.val;
        ListNode result=new ListNode(sum%10);
        ListNode current=result;
        int upper=sum/10;
        while (l1.next!=null&&l2.next!=null){
            l1=l1.next;
            l2=l2.next;

            sum=l1.val+l2.val+upper;
            upper=sum/10;

            current.next=new ListNode(sum%10);
            current=current.next;
        }

        ListNode last=l1.next!=null?l1:l2;

        while (last.next!=null&&upper!=0){
            last=last.next;

            sum=upper+last.val;
            upper=sum/10;

            current.next=new ListNode(sum%10);
            current=current.next;
        }

        if (last.next!=null) current.next=last.next;
        if (upper!=0) current.next=new ListNode(upper);

        return result;
    }
}

class Solution0002_3 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum=l1.val+l2.val;
        ListNode result=new ListNode(sum%10);
        ListNode current=result;
        int upper=sum/10;
        while (l1.next!=null&&l2.next!=null){
            l1=l1.next;
            l2=l2.next;

            sum=l1.val+l2.val+upper;
            upper=sum/10;

            current.next=new ListNode(sum%10);
            current=current.next;
        }

        ListNode last=l1.next!=null?l1:l2;

        while (last.next!=null&&upper!=0){
            last=last.next;

            sum=upper+last.val;
            upper=sum/10;

            current.next=new ListNode(sum%10);
            current=current.next;
        }

        if (last.next!=null) current.next=last.next;
        if (upper!=0) current.next=new ListNode(upper);

        return result;
    }
}