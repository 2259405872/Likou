package Sequence;

public class Test0055 {
}

class Solution0055_1 {
    public boolean canJump(int[] nums) {
        int max=nums[0];

        for (int i = 0; i < nums.length&&i<=max; i++) {
            if (nums[i]+i>max) max=nums[i]+i;
            if (max>= nums.length-1) return true;
        }

        return false;
    }
}

class Solution0055_2 {
    public boolean canJump(int[] nums) {
        int limit=0;
        for (int i = 0; i <= limit; i++) {
            if (limit>= nums.length-1) return true;

            if (i+nums[i]>limit) limit=i+nums[i];
        }

        return false;
    }
}