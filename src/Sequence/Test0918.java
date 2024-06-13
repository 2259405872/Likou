package Sequence;

public class Test0918 {
    public static void main(String[] args) {
        new Solution0918().maxSubarraySumCircular(new int[]{5,-3,5});
    }
}

class Solution0918 {
    public int maxSubarraySumCircular(int[] nums) {
        int length = nums.length;
        if (length ==0) return 0;
        int start=0,max=nums[start],sum,count;

        while (start<length) {
            sum=nums[start];
            count =start+1;
            int end = length + start;
            for (; count< end; count++) {
                int index = count % length;
                if (index==start) break;

                int num = nums[index];
                int temp = sum + num;
                if (temp<num){
                    sum=num;
                    if (sum>max) max=sum;
                    if (index>start) {
                        start = index-1;
                    }
                    break;
                }else {
                    sum=temp;
                }

                if (sum>max) max=sum;
            }

            start++;
        }

        return max;
    }
}

class Solution0035 {
    public int maxSubarraySumCircular(int[] nums) {

        // Kanade算法
        int maxKanade = maxSubarraySum(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = -nums[i];
        }
        int maxReverse = maxSubarraySum(nums);
        int maxCircle = sum + maxReverse;
        return maxKanade > 0 ? Math.max(maxKanade, maxCircle) : maxKanade;
    }

    private int maxSubarraySum(int[] nums) {

        int maxEnd = nums[0];
        int maxSofar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEnd = Math.max(maxEnd + nums[i], nums[i]);
            maxSofar = Math.max(maxSofar, maxEnd);
        }
        return maxSofar;
    }
}