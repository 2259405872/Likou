package Sequence;

import java.util.HashMap;
import java.util.Map;

public class Test0560 {
}

class Solution0560_1 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length,ans = 0,pre=0;

        map.put(0, 1);
        for (int num : nums) {
            pre += num;

            Integer count = map.get(pre - k);
            if (count != null) ans += count;

            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return ans;
    }
}