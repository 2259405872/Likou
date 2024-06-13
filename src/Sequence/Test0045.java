package Sequence;

public class Test0045 {
}

class Solution0045_1 {
    public int jump(int[] nums) {
        if (nums.length==1) return 0;
        int result = 0;
        int count=nums[0];
        int max = nums[0];

        if (max>= nums.length-1) return 1;
        for (int i = 0; i < nums.length&&i<=max; i++) {
            if (nums[i]+i>max) max=nums[i]+i;
            if (i>count){
                count=max;
                result++;
            }

            if (max>= nums.length-1) break;
        }
        return result+2;
    }
}

class Solution0045_2 {
    public int jump(int[] nums) {
        int ans = 0,limit=nums[0],oldLimit=0,len=nums.length;

        for (int i = 1; i < len; i++) {
            if (limit>=len-1) return ans+1;

            if (i>oldLimit){
                ans++;
                oldLimit=limit;
            }

            if (i+nums[i]>limit) limit=i+nums[i];

        }

        return ans;
    }
}