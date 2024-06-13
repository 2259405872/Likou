package Sequence;

public class Test0034 {
    public static void main(String[] args) {
        new Solution0034_1().searchRange(new int[] {5,7,7,8,8,10},8);
    }
}

class Solution0034_1 {
    public int[] searchRange(int[] nums, int target) {
        int lIndex = binarySearch(nums, target, true);
        int rIndex = binarySearch(nums, target, false);
        return new int[]{lIndex, rIndex};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int length = nums.length;
        int l=0, r=length-1;

        while (l<=r) {
            int mid = (l + r)/2;
            int num = nums[mid];

            if (num>target) {
                r=mid-1;
            }else if (num<target) {
                l=mid+1;
            }else {
                if (lower){
                    r=mid-1;
                }else {
                    l=mid+1;
                }
            }
        }
        int result=-1;

        if (l<length&&nums[r]==target){
            result=r;
        } else if (r>-1&&nums[l] == target) {
            result=l;
        }

        return result;
    }
}

class Solution0034_2 {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];

        ans[0] = binarySearch(nums, target, true);
        ans[1] = binarySearch(nums, target, false);

        return ans;
    }

    public int binarySearch(int[] nums, int target, boolean isFirst) {
        int l=0, r=nums.length-1,index=-1;

        while (l<=r) {
            if (target<nums[l]||target>nums[r]) break;
            int m = (l + r) >> 1;

            if (target<nums[m]) r=m-1;
            else if (target > nums[m]) l=m+1;
            else {
                index=m;
                if (isFirst) r=m-1;
                else l=m+1;
            }
        }

        return index;
    }
}

class Solution0034_3 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[1]=-1;

        ans[0]=search(nums,target,true);
        if (ans[0]!=-1)ans[1]=search(nums,target,false);
        return ans;
    }

    public int search(int[] nums, int target,boolean flag) {
        int l=0,r=nums.length-1,index=-1;

        while (l<=r){
            int m = (l+r) >> 1;

            if (nums[m]<target) l=m+1;
            else if (nums[m]>target) r=m-1;
            else{
                index=m;
                if (flag) r=m-1;
                else l=m+1;
            }
        }

        return index;
    }
}