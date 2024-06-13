package Sequence;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test0128 {
    public static void main(String[] args) {
        new Solution0128_1().longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1});
    }
}
class Solution0128_1 {
    public int longestConsecutive(int[] nums) {
        if (nums.length==0) return 0;
        int result=0;
        Arrays.sort(nums);

        int count=1;
        int temp=nums[0];
        for (int num : nums) {

            if (temp == num) {
                continue;
            } else if (temp!=num-1){
                result= Math.max(count, result);
                count=0;
            }
            count++;
            temp=num;
        }
        return Math.max(count, result);
    }
}

class Solution0128_2 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ans=0;
        for (Integer num : set) {
            if (!set.contains(num-1)){
                int now=num,count=1;

                while (set.contains(++num)) count++;

                ans=Math.max(ans,count);
            }
        }

        return ans;
    }
}