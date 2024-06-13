package Sequence;

import java.util.HashMap;

public class Test0454 {
}

class Solution0454_1 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for (int k : nums1) {
            for (int i : nums2) {
                map.put(k + i, map.getOrDefault(k + i, 0) + 1);
            }
        }

        for (int k : nums3) {
            for (int i : nums4) {
                ans += map.getOrDefault(-k - i, 0);
            }
        }

        return ans;
    }
}
