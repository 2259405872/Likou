package ShuJuJieGou_easy;

public class Practice04 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3=new int[m];
        System.arraycopy(nums1, 0, nums3, 0, m);
        int i = 0,j=0;
        for (; i < m&&j<n;) {
            if (nums3[i]<nums2[j]) {
                nums1[i+j]=nums3[i];
                i++;
            } else {
                nums1[i+j]=nums2[j];
                j++;
            }
        }
        if (i+1<=m) {
            System.arraycopy(nums3, i, nums1, j+i, m-i);
        }
        if (j+1<=n) {
            System.arraycopy(nums2, j, nums1, j+i, n-j);
        }
    }
}
