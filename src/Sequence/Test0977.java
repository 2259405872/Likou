package Sequence;

public class Test0977 {
}

class Solution0977_1 {
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        int left = 0, right = length - 1,count = length-1;

        while (left <= right) {
            int i = nums[left] * nums[left];
            int j = nums[right] * nums[right];

            if (i < j){
                ans[count--]=j;
                right--;
            }else {
                ans[count--]=i;
                left++;
            }
        }

        return ans;
    }
}


