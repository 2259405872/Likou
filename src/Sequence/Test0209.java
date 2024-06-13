package Sequence;

public class Test0209 {
    public static void main(String[] args) {
        new Solution0209_1().minSubArrayLen(7,new int[]{2,3,1,2,4,3});
    }
}
class Solution0209_1 {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int result = len+1,r=0,l=0,sum=0;
        while (r<len){
            sum+=nums[r];
            while (sum>=target){
                if(r-l+1<result) result=r-l+1;
                sum-=nums[l];
                l++;
            }
            r++;
        }

        result=result==len+1?0:result;
        return result;
    }
}

class Solution0209_2 {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int sum = 0,l=0,r=0;
        while (r<nums.length){
            sum+=nums[r++];
            if (sum<target) continue;

            while (sum>=target) sum-=nums[l++];

            ans = Math.min(ans,r-l+1);
        }

        return ans == Integer.MAX_VALUE?0:ans;
    }
}