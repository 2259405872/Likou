package Sequence;

public class Test0122 {
}

class Solution0122_1 {

    public int maxProfit(int[] prices) {
        int small=prices[0];
        int large=prices[0];
        int result =0;

        for (int price : prices) {
            if (price < large){
                result+=(large-small);
                small=price;
                large=price;
            }else {
                large=price;
            }
        }
        result+=(large-small);
        return result;
    }
}
