package ChuJiShuanFa;

import java.util.HashMap;

public class Example_01_09 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]),i};
            } else if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
        }
        return new int[]{0,0};
    }
}
