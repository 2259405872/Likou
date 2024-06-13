package Sequence;


public class Test0416 {
    public static void main(String[] args) {
        new Solution0416_1().canPartition(new int[]{2,2,3,5});
    }
}



class Solution0416_1 {
    public boolean canPartition(int[] nums) {
        int length = nums.length;
        if (length <=1) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum&1)== 1) return false;
        int target = sum>>1;

        boolean[] dp = new boolean[target+1];
        dp[0]=true;

        for (int num:nums) {
            if (dp[target]) return true;
            for (int j = target; j>num; j--)
                dp[j]=dp[j]||dp[j-num];

            if (num <target) dp[num] = true;
            else return num == target;
        }


        return dp[target];
    }
}
