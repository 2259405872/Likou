package Sequence;

import java.util.HashMap;
import java.util.Map;

public class Test0219 {
}

class Solution0219_1 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // value : index
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }
}