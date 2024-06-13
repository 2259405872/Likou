package Sequence;

public class Test0137 {
}

class Solution0137 {
    public int singleNumber(int[] nums) {
        int one=0;
        int two=0;

        for (int num : nums) {
            one = one ^ num & ~two;
            two = two ^ num&~one;
        }

        return one;
    }
}
