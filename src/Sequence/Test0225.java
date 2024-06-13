package Sequence;

import java.util.ArrayDeque;
import java.util.Queue;

public class Test0225 {
}

class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue=new ArrayDeque<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        int size = queue.size();
        while (--size >= 0) queue.offer(queue.poll());
        return queue.poll();
    }

    public int top() {
        int size = queue.size();
        while (--size >= 0) queue.offer(queue.poll());
        Integer poll = queue.poll();
        queue.offer(poll);
        return poll;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

}
