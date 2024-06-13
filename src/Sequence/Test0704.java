package Sequence;

public class Test0704 {
}

class Solution0704_1 {
    public int search(int[] nums, int target) {
        int length = nums.length;

        int i=0,j=length-1;
        while(i<=j){
            int m = (i + j) >> 1;

            if(nums[m]==target)return m;
            else if(nums[m]>target)j=m-1;
            else i=m+1;
        }

        return -1;

    }
}

class Solution0704_2 {
    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1;

        while(l<=r){
            int mid = (r + l) >> 1;

            if(nums[mid]==target)return mid;
            else if(nums[mid]>target)r=mid-1;
            else l=mid+1;
        }

        return -1;
    }
}