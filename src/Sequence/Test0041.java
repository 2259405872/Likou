package Sequence;

public class Test0041 {
}

class Solution0041_1 {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int[] ints = new int[length];

        for (int num : nums) if (num>0&&num<=length)ints[num-1]=1;

        for (int i = 0; i < length; i++) if (ints[i]==0) return i+1;

        return length+1;
    }
}