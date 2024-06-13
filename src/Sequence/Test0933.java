package Sequence;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Test0933 {
}

class RecentCounter {

    Deque<Integer> deque;
    public RecentCounter() {
        deque=new LinkedList<Integer>();
    }

    public int ping(int t) {
        deque.offer(t);

        int flag = t - 3000;

        while (deque.peek()<flag) deque.poll();

        return deque.size();
    }
}