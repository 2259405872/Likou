package Sequence;

import java.util.LinkedHashMap;
import java.util.Map;

public class Test0146 {
    public static void main(String[] args) {
        LRUCache_01 cache = new LRUCache_01(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
    }
}

class LRUCache_01 {
    int size=0;
    int capacity;
    LNode_01 headPre=new LNode_01();
    LNode_01 tail=headPre;
    public LRUCache_01(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        LNode_01 current=headPre;
        while (current.next != null) {
            if (current.next.key==key){
                tail.next=current.next;
                current.next=current.next.next;

                tail=tail.next;
                tail.next=null;

                return tail.val;
            }
            current = current.next;
        }
        return -1;
    }

    public void put(int key, int value) {
        LNode_01 current=headPre;
        while (current.next != null) {
            if (current.next.key==key){
                current.next.val=value;

                tail.next=current.next;
                current.next=current.next.next;

                tail=tail.next;
                tail.next=null;
                return;
            }
            current = current.next;
        }

        tail.next=new LNode_01(key,value);
        tail=tail.next;
        size++;
        if (size>capacity){
            headPre.next=headPre.next.next;
            size--;
        }
    }

    class LNode_01 {
        int key;
        int val;
        LNode_01 next;

        LNode_01() {
        }

        LNode_01(int key, int val) {
            this.key = key;
            this.val = val;
        }

        LNode_01(int key, int val, LNode_01 next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
}

class LRUCache extends LinkedHashMap<Integer,Integer> {
    int capacity;
    public LRUCache(int capacity) {
        super(capacity,1,true);
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer result = super.get(key);
        return result ==null?-1:result;
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}