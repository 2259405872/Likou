package Sequence;

public class Test0283 {
}

class Solution0283_1 {
    public void moveZeroes(int[] nums) {
        int length = nums.length;

        int count=0;
        for (int i = 0; i+count < length; i++) {
            while (nums[i+count]==0&&i+count<length-1) count++;
            nums[i]=nums[i+count];
        }

        for (int i = length-count; i < length; i++) nums[i]=0;
    }
}

class Solution0283_2 {
    public void moveZeroes(int[] nums) {
        int length = nums.length,count=0;

        for(int i=0; i<length; i++)
            if (nums[i]!=0) nums[count++]=nums[i];

        for (int i = count; i < length; i++) nums[i]=0;
    }
}