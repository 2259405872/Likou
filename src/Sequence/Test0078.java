package Sequence;

import java.util.ArrayList;
import java.util.List;

public class Test0078 {
    public static void main(String[] args) {
        new Solution0078_1().subsets(new int[]{1, 2, 3});
    }
}


class Solution0078_1 {
    List<List<Integer>> ans=new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        ans.add(new ArrayList<Integer>());

        for (int i = 0; i <= nums.length; i++) {
            for (int j = 1; j <=i+1; j++) {
                traverse(nums,i,j);
            }
        }

        return ans;
    }

    public void  traverse(int[] nums,int end,int size){
        int[] ints=new int[size];
        ints[size-1]=nums[end];
        System.arraycopy(nums,0,ints,0,size-1);

        for (int i = 1; i <= end+1- size&&size>1; i++) {
            build(ints);
            System.arraycopy(nums,i,ints,0,size-1);
        }
        build(ints);
    }

    public void build(int[] ints){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i:ints) list.add(i);
        ans.add(list);
    }
}