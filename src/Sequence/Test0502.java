package Sequence;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test0502 {
    public static void main(String[] args) {
        int maximizedCapital = new Solution0502_1().findMaximizedCapital(1, 2, new int[]{1, 2, 3}, new int[]{1, 1, 2});
        System.out.println(maximizedCapital);
    }
}

class Solution0502_1 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int result=0,temp=w;

        int[][] list = new int[profits.length][2];
        for (int i = 0; i < profits.length; i++) {
            list[i][0]=capital[i];
            list[i][1]=profits[i];
        }

        Arrays.sort(list, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a,b)->b-a);
        int index=0;
        for (int i = k; i > 0; i--) {
            while (index<list.length&&list[index][0]<=temp){
                maxQueue.offer(list[index++][1]);
            }
            Integer maxProfit = maxQueue.poll();

            if (maxProfit != null) {
                result+= maxProfit;
                temp+=maxProfit;
            }

        }

        return result+w;
    }
}