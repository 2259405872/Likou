package Sequence;

public class Test0004 {
    public static void main(String[] args) {
        new Solution0004_2().findMedianSortedArrays(new int[]{5}, new int[]{1,2,3,4,6,7});
    }
}

/*
给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

算法的时间复杂度应该为 O(log (m+n)) 。



示例 1：

输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
示例 2：

输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
*/

class Solution0004_1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result=0;
        int slen=nums1.length+nums2.length;
        double s=(slen%2+1)%2+1;
        double meindex=slen/2.0;
        int m=0,n=0;
        for (int i=0; i<=meindex;i++){
            boolean loop = i == meindex - 0.5 || i == meindex - 1 || i == meindex;
            if (m< nums1.length&&n<nums2.length) {
                if (nums1[m]>nums2[n]){
                    if(loop){
                        result+=nums2[n];
                    }
                    n++;
                }else {
                    if(loop){
                        result+=nums1[m];
                    }
                    m++;
                }
            } else if(m< nums1.length){
                if(loop){
                    result+=nums1[m];
                }
                m++;
            }else{
                if(loop){
                    result+=nums2[n];
                }
                n++;
            }
        }
        return  result/s;
    }
}

class Solution0004_2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int medium1=0;
        int medium2=0;

        int length1 = nums1.length;
        int length2 = nums2.length;

        int midLen = (length1 + length2+1) / 2;
        int flag1=-1;
        int flag2=-1;

        while (midLen>1){
            int count = midLen / 2;

            int move1= Math.min(length1 - flag1 - 1, count);
            int move2=Math.min(length2 - flag2 - 1, count);

            if (move1 == 0){
                flag2+=count;
                midLen-=count;
                continue;
            } else if (move2 == 0) {
                flag1+=count;
                midLen-=count;
                continue;
            }

            if (nums1[move1+flag1]>nums2[move2+flag2]){
                flag2+=move2;
                midLen-=move2;
            }else {
                flag1+=move1;
                midLen-=move1;
            }
        }

        if (flag1==length1-1){
            medium1=nums2[++flag2];
        } else if (flag2 == length2 - 1) {
            medium1=nums1[++flag1];
        }else {
            if (nums1[flag1+1]<nums2[flag2+1]){
                medium1=nums1[++flag1];
            }else {
                medium1=nums2[++flag2];
            }
        }

        if ((length1+length2)%2==0){
            if (flag1==length1-1){
                medium2=nums2[++flag2];
            } else if (flag2 == length2 - 1) {
                medium2=nums1[++flag1];
            }else {
                if (nums1[flag1+1]<nums2[flag2+1]){
                    medium2=nums1[++flag1];
                }else {
                    medium2=nums2[++flag2];
                }
            }
            return (medium2+medium1)/2.0;
        }else {
            return medium1;
        }
    }
}

class Solution0004_3 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        if (length1>length2) return findMedianSortedArrays(nums2,nums1);

        double midLength = (length1 + length2+1)/2.0;

        int l1 = 0, l2 = 0,r1 = length1-1,r2 = length2-1,count = 0;

        while (midLength>0.5){
            if (r1<l1||length1==0){
                l2+=(int)midLength;
                break;
            }else if(r2<l2){
                l1+=(int)midLength;
                break;
            }

            int m1 = (l1 + r1) >> 1;
            int m2=(int)(l2+midLength-(m1-l1+1));

            if (nums1[m1]>=nums2[m2]){
                midLength-=m2-l2+1;
                l2=m2+1;
                r1=m1;
            } else if (nums1[m1] < nums2[m2]) {
                midLength-=m1-l1+1;
                l1=m1+1;
                r2=m2;
            }

        }

        int leftValue = Math.max(l1 == 0 ? Integer.MIN_VALUE : nums1[l1 - 1], l2 == 0 ? Integer.MIN_VALUE : nums2[l2 - 1]);
        if (midLength%1>0){
            int rightValue = Math.min(l1 == length1 ? Integer.MAX_VALUE : nums1[l1], l2 == length2 ? Integer.MAX_VALUE : nums2[l2]);
            return (leftValue+rightValue)/2.0;
        }else {
            return leftValue;
        }
    }
}