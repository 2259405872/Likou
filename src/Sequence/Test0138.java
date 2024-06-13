package Sequence;

public class Test0138 {
}

class Solution0138_1 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        //将新节点插入到所有旧节点的next
        for (Node node=head; node!=null; node=node.next.next){
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
        }

        //新的头结点
        Node newHead = head.next;

        //将新节点的random补全
        for (Node node=head; node!=null; node=node.next.next){
            Node newNode = node.next;
            newNode.random=node.random!=null?node.random.next:null;
        }

        //将新旧节点分开
        for (Node node=head; node!=null; node=node.next){
            Node newNode = node.next;
            node.next=newNode.next;
            newNode.next=node.next!=null?node.next.next:null;
        }
        return newHead;
    }
}

class Solution0138_2 {
    public Node copyRandomList(Node head) {
        if(head==null) return null;

        Node now = head;
        while (now!=null){
            Node newNode = new Node(now.val);

            newNode.next=now.next;
            now.next=newNode;

            now=newNode.next;
        }

        now=head;
        Node ans = head.next;
        while (now!=null){
            Node newNode = now.next;
            Node next = newNode.next;

            newNode.random=(now.random==null)?null:now.random.next;

            now=next;
        }

        now=head;
        while (now!=null){
            Node newNode = now.next;
            Node next = now.next.next;

            now.next=next;
            newNode.next=(next==null)?null:next.next;

            now=next;
        }

        return ans;
    }
}