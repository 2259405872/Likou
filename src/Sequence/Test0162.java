package Sequence;

public class Test0162 {
}

class Solution0162_1 {
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        if (length==1) return 0;
        int l=0, r=length-1,mid=l;

        while (l<r){
            mid = (r + l) / 2;
            if (nums[mid+1]>nums[mid]){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return r;
    }
}