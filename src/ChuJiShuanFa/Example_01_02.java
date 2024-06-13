package ChuJiShuanFa;

public class Example_01_02 {
    public int maxProfit(int[] prices) {
        int buy=prices[0];
        int amount=0;

        for (int i : prices) {
            if (i<buy) {
                buy=i;
            } else if(i>buy){
                amount+=i-buy;
                buy=i;
            }
        }
        
        return amount;
    }
}
