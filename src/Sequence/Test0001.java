package Sequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Test0001 {
}



//
//    给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
//
//        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//
//        你可以按任意顺序返回答案。


class Solution01 {
    public int[] twoSum(int[] nums, int target) {
        int[] solution = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j]==(target-nums[i])){
                    solution[0]=i;
                    solution[1]=j;
                    return solution;
                }
            }
        }



        return solution;
    }
}

class Solution02 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}

class Solution0001_second {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0,j=nums.length-1; i <=j;i++,j--) {
            int n1 = target - nums[i];
            int n2 = target - nums[j];

            if (map.containsKey(n1)) return new int[]{i, map.get(n1)};
            map.put(nums[i],i);

            if (map.containsKey(n2)) {
                if (j!=map.get(n2)){
                    return new int[]{j, map.get(n2)};
                }
            }
            map.put(nums[j],j);
        }
        return new int[]{-1, -1};
    }
}

class Solution0001_3 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int sub1 = target - num;
            int sub2 = num - target ;

            if (map.containsKey(sub1)) return new int[]{map.get(sub1),i};
            if (map.containsKey(sub2)) return new int[]{map.get(sub2),i};
            else map.put(num,i);
        }

        return new int[]{};
    }
}

class Solution0001_4 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num=nums[i];
            if (map.get(target - num)!=null) return new int[]{i,map.get(target - num)};
            map.put(num,i);
        }

        return null;
    }
}