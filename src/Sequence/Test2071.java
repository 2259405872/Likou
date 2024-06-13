package Sequence;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Test2071 {
    public static void main(String[] args) {
        new Solution2017_1().maxTaskAssign(new int[]{3,2,1},new int[]{0,3,3},1,1);
    }
}

class Solution2017_1 {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int tCount = tasks.length;
        int wCount = workers.length;

        Arrays.sort(tasks);
        Arrays.sort(workers);

        int l=0,r= Math.min(tCount, wCount);

        while (l<=r){
            int mid = (r + l) >> 1;

            if (check(tasks,workers,mid,pills,strength)) l=++mid;
            else r=--mid;
        }

        return r;
    }

    public boolean check(int[] tasks, int[] workers,int count,int pills, int strength){
        Deque<Integer> queue = new ArrayDeque<>();
        int index = workers.length - 1;

        for (int i = count - 1; i >= 0; i--) {
            int task = tasks[i];
            while (index>=0&&workers[index]+strength>= task) queue.addLast(workers[index--]);
            
            if (queue.size()==0) return false;

            if (queue.getFirst()>=task) queue.removeFirst();
            else if (pills-- > 0) queue.removeLast();
            else return false;

        }

        return true;
    }
}
