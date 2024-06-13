package Sequence;

public class Test0707 {
    public static void main(String[] args) {

    }
}

class MyLinkedList {
    int size;
    N head;

    public MyLinkedList() {
        size = 0;
        head = new N(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        N cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        index = Math.max(0, index);
        size++;
        N pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        N toAdd = new N(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        N pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }

    static class N {
        int val;
        N next;

        public N(int val) {
            this.val = val;
        }
    }
}


