package Sequence;

public class Test0088 {
}

class Solution0088_1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int m1=m-1,n1=n-1,tail=m+n-1;
        while (m1>=0&n1>=0){
            if (nums1[m1]>=nums2[n1]){
                nums1[tail--]=nums1[m1];
                m1--;
            }else{
                nums1[tail--]=nums2[n1];
                n1--;
            }
        }

        if (m1>=0){
            while (tail>=0) {
                nums1[tail--]=nums1[m1--];
            }
        }else {
            while (tail>=0) {
                nums1[tail--] = nums2[n1--];
            }
        }
    }
}