package Sequence;

public class Test0153 {
}

class Solution0153_1 {
    public int findMin(int[] nums) {
        int length = nums.length;
        int l=0,r=length-1;


        while (l<r) {
            int rNum=nums[r];
            int lNum=nums[l];
            int mid = (r + l) / 2;
            int midNum = nums[mid];

            if (midNum>=lNum&&midNum>rNum){
                l=mid+1;
            }else {
                r=mid;
            }
        }

        return nums[r];
    }
}

class Solution0153_2 {
    public int findMin(int[] nums) {
        int length = nums.length;
        int l=0,r=length-1;
        while (l<=r) {
            if(nums[l]<=nums[r]) break;
            int m = (l+r)>>1;

            if (nums[m]<nums[l]) r=m;
            else l=m+1;
        }

        return nums[l];
    }
}