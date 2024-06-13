package Sequence;

public class Test0053 {
}

class Solution0053_1 {
    public int maxSubArray(int[] nums) {
        int sum=nums[0],max=sum;
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            int num=nums[i];
            int temp = sum + num;
            sum = Math.max(num, temp);

            if (sum>max)max=sum;
        }
        return max;
    }
}

class Solution0053_2 {
    public int maxSubArray(int[] nums) {
        int ans=nums[0],length=nums.length,sum=ans;

        for (int i = 1; i < length; i++) {
            int num = nums[i];
            sum = Math.max(num,sum+num);

            ans = Math.max(ans,sum);
        }

        return ans;
    }
}