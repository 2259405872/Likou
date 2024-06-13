package Sequence;

public class Test0136 {
}

class Solution0136_1 {
    public int singleNumber(int[] nums) {
        int len = nums.length;
        int ans = nums[0];
        for(int i = 1; i < len; i ++){
            ans = ans ^ nums[i];
        }
        return ans;
    }
}

class Solution0136_2 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) ans ^= num;
        return ans;
    }
}