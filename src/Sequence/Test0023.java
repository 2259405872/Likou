package Sequence;

public class Test0023 {
}

class Solution0023 {
    ListNode[] lists;
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length==0) return null;
        this.lists = lists;
        return merge(0, length-1);
    }

    public ListNode merge(int start,int end){
        if (start==end) return lists[start];
        int mid = (start + end) / 2;
        ListNode left = merge(start, mid);
        ListNode right = merge(mid+1, end);

        return sort(left,right);
    }

    public ListNode sort(ListNode left,ListNode right){
        ListNode result = new ListNode(),temp = result;
        while (left!=null&&right!=null){
            if (left.val<right.val){
                temp.next=left;
                temp=left;
                left=left.next;
            }else {
                temp.next=right;
                temp=right;
                right=right.next;
            }
        }

        temp.next=left!=null?left:right;

        return result.next;
    }
}

class Solution0023_1 {
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length==0) return null;

        return merge(lists,0,length-1);
    }

    public ListNode merge(ListNode[] lists,int s,int e){
        if (s==e) return lists[s];

        int m = (s + e) / 2;

        ListNode l = merge(lists, s, m);
        ListNode r = merge(lists, m + 1, e);

        return sort(l,r);
    }

    public ListNode sort(ListNode l,ListNode r) {
        ListNode ans = new ListNode(),temp = ans;

        while (l!=null&&r!=null){
            if (l.val<= r.val){
                temp.next=l;
                temp=l;
                l=l.next;
            }else {
                temp.next=r;
                temp=r;
                r=r.next;
            }
        }

        temp.next=r==null?l:r;

        return ans.next;
    }
}