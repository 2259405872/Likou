package Sequence;

public class Test0188 {
}

class Solution0188_1 {
    public int maxProfit(int k, int[] prices) {
        int[] records = new int[k * 2];
        for (int i = 0; i < k; i++) {
            records[i*2] = -prices[0];
        }

        for (int price : prices) {
            records[0]=Math.max(records[0],-price);
            records[1]=Math.max(records[1],records[0]+price);

            for (int i = 1; i < k; i++) {
                int index = i * 2;
                records[index]=Math.max(records[index],records[index-1]-price);
                records[index+1]=Math.max(records[index+1],records[index]+price);
            }
        }

        return records[k*2-1];

    }
}