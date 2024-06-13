package Sequence;

import java.util.ArrayList;
import java.util.List;

public class Test0057 {
    public static void main(String[] args) {
        new Solution0057_1().insert(new int[][]{{1,3},{6,9}},new int[]{2,5});
    }
}

class Solution0057_1 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length==0) return new int[][]{newInterval};

        List<int[]> result = new ArrayList<>();
        int start=newInterval[0],end=newInterval[1];
        int i = 0;
        for (; i < intervals.length; i++) {
            int[] nums = intervals[i];
            if (nums[1]<start) {
                result.add(nums);
            }else {
                start=Math.min(nums[0],start);
                end=end;

                for(;i<intervals.length; i++){
                    nums = intervals[i];
                    if(end<nums[0]){
                        break;
                    }else if(end<nums[1]){
                        end=nums[1];
                        i++;
                        break;
                    }
                }
                break;
            }
        }

        result.add(new int[]{start,end});
        for (; i < intervals.length; i++) {
            int[] nums = intervals[i];
            result.add(nums);
        }

        return result.toArray(new int[result.size()][2]);
    }
}
