package Sequence;

import java.util.*;

public class Test0046 {
    public static void main(String[] args) {
        new Solution0046_2().permute(new int[]{1,2,3});
    }
}

class Solution0046_1 {
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (length<1) return result;

        int[] counts = new int[length];
        for (int i = 0; i < length; i++) {
            counts[i] = length-i;
        }

        Deque<Integer> numDeque=new LinkedList<>();
        for (int num : nums) {
            numDeque.offer(num);
        }

        Integer[] temp = new Integer[length];

        int rowIndex=0;
        while (rowIndex>=0) {
            if (counts[rowIndex]>0){
                Integer num = numDeque.poll();
                temp[rowIndex]=num;
                counts[rowIndex]--;
                if (rowIndex==length-1){
                    numDeque.offer(temp[rowIndex]);
                    result.add(List.of(temp));

                    counts[rowIndex]=1;
                    rowIndex--;
                    if (rowIndex>=0) numDeque.offer(temp[rowIndex]);
                }else {
                    rowIndex++;
                }

            }else {
                counts[rowIndex]=length-rowIndex;
                rowIndex--;

                if(rowIndex>=0) numDeque.offer(temp[rowIndex]);
            }
        }

        return result;
    }
}

class Solution0046_2 {
    ArrayList<List<Integer>> ans=new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;

        traverse(nums,new boolean[length],new Integer[length],0,length);

        return ans;
    }

    public void traverse(int[] nums,boolean[] records,Integer[] list,int index,int length) {
        if (index==length){
            ans.add(List.of(list));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!records[i]) {
                list[index]=nums[i];

                records[i]=true;
                traverse(nums, records, list, index+1, length);
                records[i]=false;
            }
        }
    }

}