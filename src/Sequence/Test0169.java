package Sequence;

public class Test0169 {
}

class Solution0169_1 {
    public int majorityElement(int[] nums) {
        int now=nums[0],len=nums.length,count=1;

        for(int i=1;i<len;i++)
            if(nums[i]==now) count++;
            else if (count>1) count--;
            else now=nums[i];
        return now;
    }
}
