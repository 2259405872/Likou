package Sequence;

public class Test0238 {
}

class Solution0238_1 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int temp=1;
        for (int i = 0; i < nums.length; i++) {
            result[i]=temp;
            temp*=nums[i];
        }
        temp=1;
        for (int i = nums.length-1; i >-1; i--) {
            result[i]*=temp;
            temp*=nums[i];
        }
        return result;
    }
}

class Solution0238_2 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] temp = new int[length];

        int multiply=1;
        for (int i = length-1; i >= 0; i--) {
            multiply*=nums[i];
            temp[i] = multiply;
        }

        multiply=1;
        for (int i = 0; i < length-1; i++) {
            int now = nums[i];
            nums[i]= temp[i + 1]*multiply;
            multiply*=now;
        }

        nums[length-1]=multiply;
        return nums;
    }
}