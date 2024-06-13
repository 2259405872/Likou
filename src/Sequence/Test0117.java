package Sequence;

public class Test0117 {
}

class Solution0117_1 {
    public Node1 connect(Node1 root) {
        if (root == null) return null;

        Node1 head=root;
        while (head!=null){
            Node1 temp=head;

            head=null;
            Node1 current=head;
            while (temp!=null){
                boolean lIsNull = temp.left != null;
                boolean rIsNull = temp.right != null;
                if(head==null){
                    if(lIsNull){
                        head=temp.left;
                        current=head;
                       if (rIsNull){
                            current.next=temp.right;
                            current=temp.right;
                       }
                    }else if(rIsNull){
                        head=temp.right;
                        current=head;
                    }
                }else {
                    if (lIsNull){
                        current.next=temp.left;
                        current=temp.left;
                    }
                    if (rIsNull){
                        current.next=temp.right;
                        current=temp.right;
                    }
                }

                temp=temp.next;
            }
        }

        return root;
    }
}