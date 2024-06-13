package Sequence;

public class Test0075 {
}

class Solution0075_1 {
    public void sortColors(int[] nums) {
        int red = 0,length=nums.length,blue = length-1;
        for (int num : nums) {
            if (num==0) red++;
            else if (num==2) blue--;
        }

        for (int i = 0; i < length; i++) {
            if (i<red) nums[i] = 0;
            else if (i>blue) nums[i] = 2;
            else nums[i] = 1;
        }

    }
}
