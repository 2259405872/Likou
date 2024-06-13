package Sequence;

public class Test0033 {
    public static void main(String[] args) {
        new Solution0033_2().search(new int[]{3,1},1);
    }
}

class Solution0033_1 {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int l=0,r= length-1;

        while (l<=r){
            int num1 = nums[l];
            if (target==num1) return l;
            int num2 = nums[r];
            if (target==num2) return r;

            int mid = (l + r) / 2;
            int num = nums[mid];
            if (num==target) return mid;

            if (num<= num2){
                if (target>num&&target<= num2){
                    l=mid+1;
                }else {
                    r=mid-1;
                }
            }else {
                if(target>= num1 &&target<num){
                    r=mid-1;
                }else {
                    l=mid+1;
                }
            }
        }

        return -1;
    }
}

class Solution0033_2 {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int l=0,r=length-1;

        while (l<=r){
            int m = (l + r) >> 1;
            if (nums[m]==target)return m;
            if (nums[l]<=nums[r]) {
                if ((target>nums[r]||target<nums[l])) return -1;
                if (target<nums[m]) r=m-1;
                else l=m+1;
            }else {
                if ((target>nums[r]&&target<nums[l])) return -1;
                if ((nums[m]>=nums[l]&&!(target>=nums[l]&&target<nums[m]))||(nums[m]<nums[l]&&target<=nums[r]&&target>nums[m])) l=m+1;
                else r=m-1;
            }


        }

        return -1;
    }
}

