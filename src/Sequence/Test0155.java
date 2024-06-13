package Sequence;

import java.util.Objects;
import java.util.Stack;

public class Test0155 {
}

class MinStack0155_1 {
    private int size=0;
    private int maxLen=10;
    private int[] stack;
    private Stack<Integer> mins=new Stack<Integer>();
    public MinStack0155_1() {
        stack = new int[maxLen];
    }

    public void push(int val) {
        if (size>=maxLen){
            maxLen*=2;
            int[] temp = new int[maxLen];
            System.arraycopy(stack, 0, temp, 0, size);
            stack=temp;
        }
        if(mins.isEmpty()||val< stack[mins.peek()]) mins.push(size);
        stack[size++] = val;
    }

    public void pop() {
        size--;
        if (mins.peek()==size) mins.pop();
    }

    public int top() {
        return stack[size-1];
    }

    public int getMin() {
        Integer min=null;
        if (!mins.isEmpty()) min=stack[mins.peek()];
        return min;
    }
}

/**
 * Your MinStack0155_2 object will be instantiated and called as such:
 * MinStack0155_2 obj = new MinStack0155_2();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class MinStack0155_2 {
    N_01 top;
    N_01 min;

    public MinStack0155_2() {
        this.top=null;
        this.min=null;
    }

    public void push(int val) {
        top= new N_01(val, top);
        if (min==null||min.val>=top.val) min= new N_01(val, min);
    }

    public void pop() {
        if (Objects.equals(top.val, min.val)) min=min.next;
        top=top.next;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return min.val;
    }

    static class N_01 {
        N_01 next;
        Integer val;
        N_01(Integer val, N_01 next) {
            this.val = val;
            this.next = next;
        }
    }
}

