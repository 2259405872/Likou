package ChuJiShuanFa;

import java.util.ArrayList;
import java.util.Arrays;

public class Example_01_06 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list=new ArrayList<>();
        for (int i=0,j= 0; i < nums1.length&&j<nums2.length;) {
            if (nums1[i]==nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                i++;
            }
        }
        int[] list1=new int[list.size()];
        for (int i = 0; i < list1.length; i++) {
            list1[i]=list.get(i);
        }
        return list1;
    }
}
