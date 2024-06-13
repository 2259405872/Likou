package Sequence;

public class Test0021 {
}

//    将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
        /*输入：l1 = [1,2,4], l2 = [1,3,4]
        输出：[1,1,2,3,4,4]
        示例 2：

        输入：l1 = [], l2 = []
        输出：[]
        示例 3：

        输入：l1 = [], l2 = [0]
        输出：[0]
*/

class Solution0021_1{
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode temp = result;
        while (list1!=null&&list2!=null) {
            temp.next=new ListNode();
            temp=temp.next;
            if (list1.val > list2.val) {
                temp.val=list2.val;
                list2=list2.next;
            }else {
                temp.val=list1.val;
                list1=list1.next;
            }
        }
        if (list1==null){
            temp.next=list2;
        } else {
            temp.next=list1;
        }
        result=result.next;
        return result;
    }
}

class Solution0021_second {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null||list2==null) return list1!=null?list1:list2;
        ListNode result;
        if (list1.val<=list2.val){
            result=list1;
            list1=list1.next;
        }else {
            result=list2;
            list2=list2.next;
        }
        ListNode current=result;

        while (list1!=null&&list2!=null) {
            if (list1.val<=list2.val){
                current.next=list1;
                list1=list1.next;
            }else {
                current.next=list2;
                list2=list2.next;
            }
            current=current.next;
        }

        current.next=list1!=null?list1:list2;

        return result;
    }
}

class Solution0021_2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(),temp =ans;


        while (list1!=null&&list2!=null){
            if (list1.val<=list2.val){
                temp.next=list1;
                temp=list1;
                list1=list1.next;
            }else {
                temp.next=list2;
                temp=list2;
                list2=list2.next;
            }
        }

        temp.next=list1!=null?list1:list2;

        return ans.next;
    }
}