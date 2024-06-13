package Sequence;

import java.util.Arrays;

public class Test0016 {
}
class Solution0016_1 {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[1] + nums[2] + nums[3];
        int distance = Math.abs(target - result);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int first = i;
            int second = i + 1;
            int third = nums.length - 1;
            while (second < third) {
                int sum = nums[third] + nums[second] + nums[first];
                int temp = Math.abs(target - sum);
                if (temp < distance) {
                    distance = temp;
                    result = sum;
                }
                if(sum>target){
                    third--;
                } else if (sum < target) {
                    second++;
                }else {
                    return result;
                }
            }
        }
        return result;
    }
}