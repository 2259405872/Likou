package Sequence;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Test0433 {
}


class Solution0433 {

    String[] bank;
    int[] du;
    Deque<String> temp;
    String endGene;

    public int minMutation(String startGene, String endGene, String[] bank) {
        if (Objects.equals(startGene, endGene)) return 0;

        int result=0;
        this.du=new int[bank.length];
        this.bank=bank;
        this.endGene=endGene;

        Deque<String> deque=new ArrayDeque<>();
        temp=new ArrayDeque<>();
        deque.offer(startGene);

        while (!deque.isEmpty()){
            for (String start : deque) {
                if (traversal(start)) return result;
                deque.poll();
            }

            deque=temp;
            temp=new ArrayDeque<>();
            result++;

        }

        return -1;
    }

    public boolean traversal(String start){
        if (Objects.equals(start, endGene)) return true;

        for (int i=0; i<bank.length; i++){
            String end = bank[i];
            if (du[i]==0&&canChange(start, end)){
                du[i]++;
                temp.offer(end);
            }
        }

        return false;
    }

    public boolean canChange(String start, String result){
        int count=0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i)!=result.charAt(i)) count++;
        }

        return count==1;
    }
}