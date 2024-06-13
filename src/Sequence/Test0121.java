package Sequence;

public class Test0121 {
}

class Solution0121_1 {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int result=0;

        for (int price : prices) {
            if (price<min){
                min=price;
            } else if ((price - min) > result) {
                result=price-min;
            }
        }
        return result;
    }
}

class Solution0121_2 {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int result=0;

        for (int price : prices)
            if (price<min) min=price;
            else result=Math.max(result,price - min);

        return result;
    }
}
