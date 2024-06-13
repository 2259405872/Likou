package Sequence;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Test0322 {
    public static void main(String[] args) {
        new Solution0322_3().coinChange(new int[]{1, 2, 5}, 11);
    }
}

class Solution0322_1 {
    public int coinChange(int[] coins, int amount) {
        if (amount==0) return 0;
        int[] steps = new int[amount + 1];
        Arrays.fill(steps, -1);
        steps[0] = 0;

        for (int i = 0; i < amount; i++) {
            if (steps[i]==-1) continue;
            for (int coin : coins) {
                int sum = coin + i;
                if (sum<=amount&&steps[sum]==-1){
                    steps[sum]=steps[i]+1;
                }
            }
        }

        return steps[amount];
    }
}

class Solution0322_2 {
    public int coinChange(int[] coins, int amount) {
        if (amount==0) return 0;

        int result=0;
        HashSet<Integer> record = new HashSet<>();
        record.add(0);
        Queue<Integer> dp = new LinkedList<>();

        dp.offer(0);
        while (!dp.isEmpty()) {
            result++;
            LinkedList<Integer> temp = new LinkedList<>();
            while (!dp.isEmpty()){
                Integer poll = dp.poll();
                for (int coin : coins) {
                    int sum = poll + coin;
                    if (sum <amount&&!record.contains(sum)){
                        temp.offer(sum);
                        record.add(sum);
                    } else if (sum == amount) return result;
                }
            }

            dp=temp;
        }

        return -1;
    }
}

class Solution0322_3 {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;

        int[] records = new int[amount+1];
        Arrays.fill(records, Integer.MAX_VALUE);
        for (int coin : coins)
            if (coin<=amount) records[coin]=1;

        for (int i = 1; i <= amount; i++) {
            int record = records[i];
            if (record ==Integer.MAX_VALUE) continue;

            for (int coin : coins){
                int sum = coin + i;
                if (sum <=amount&&sum>=0)
                    records[sum]=Math.min(record+1, records[sum]);
            }

        }

        return records[amount]==Integer.MAX_VALUE?-1:records[amount];
    }
}