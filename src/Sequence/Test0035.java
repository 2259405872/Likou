package Sequence;

public class Test0035 {
}

class Solution0035_1 {
    public int searchInsert(int[] nums, int target) {
        int i=0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i]>=target){
               return i;
            }
        }
        return i+1;
    }
}

class Solution0035_2 {
    public int searchInsert(int[] nums, int target) {
        int r=nums.length-1;
        int l=0;
        while (l<=r) {
            int mid=(r-l)/2+l;
            if (nums[mid]>=target){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return l;
    }
}

class Solution0035_3 {
    public int searchInsert(int[] nums, int target) {
        if(target<nums[0]){
            return 0;
        }else if(target>nums[nums.length-1]){
            return nums.length;
        }

        int left=0,right=nums.length-1,mid;
        do{
            mid = (left + right) / 2;
            int num = nums[mid];
            if (num>target){
                right=mid;
            } else if (num < target) {
                left=mid+1;
            }else {
                return mid;
            }
        }while (left<right);

        return right;
    }
}

class Solution0035_04 {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int l=0,r=length;

        while(l<r) {
            int m = (r + l) >> 1;

            if(nums[m]<target) l=m+1;
            else if(nums[m]>target) r=m;
            else return m;
        }

        return r;
    }
}