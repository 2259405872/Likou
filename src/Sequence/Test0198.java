package Sequence;

public class Test0198 {
}

class Solution0198_1 {
    public int rob(int[] nums) {
        int preTwo=0,preOne=0,ans=0;

        for (int num : nums) {
            preTwo=preOne;
            preOne=ans;

            ans=Math.max(preOne,num+preTwo);
        }

        return ans;
    }
}

class Solution0198_2 {
    public int rob(int[] nums) {
        int p2= 0,p1=0,ans=nums[0];

        for (int i=1;i<nums.length;i++) {
            p2=p1;
            p1=ans;

            ans=Math.max(p1,nums[i]+p2);
        }

        return ans;
    }
}