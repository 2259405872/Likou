package ShuJuJieGou_easy;

public class Practice02 {
    public int maxSubArray(int[] nums) {
        int count=0;
        int maxNum=nums[0];
        for (int n:nums) {
            count=Math.max(count+n, n);
            maxNum=Math.max(maxNum, count);
        }
        return maxNum;
    }
}
