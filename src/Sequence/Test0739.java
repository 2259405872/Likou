package Sequence;

import java.util.Deque;
import java.util.LinkedList;

public class Test0739 {
}

class Solution0739_1 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> records = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            int old;
            while (!records.isEmpty()&&temperatures[(old=records.peekLast())]<temperatures[i])
                temperatures[old]=i-records.pollLast();

            records.offer(i);
        }

        while (!records.isEmpty())  temperatures[records.pollLast()]=0;
        return temperatures;
    }
}