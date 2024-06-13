package Sequence;

import java.util.*;

public class Test0056 {
}

class Solution0056_1 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> result = new ArrayList<>();
        int l=intervals[0][0], r=intervals[0][1];
        for (int[] nums : intervals) {
            if (nums[0]<=r){
                if(nums[0]<l) l=nums[0];
                if(nums[1]>r) r=nums[1];
            }else {
                result.add(new int[]{l,r});
                l=nums[0];
                r=nums[1];
            }
        }
        result.add(new int[]{l,r});
        return result.toArray(new int[result.size()][2]);
    }
}

class Solution0056_2 {
    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        Arrays.sort(intervals,(x,y)->x[0]-y[0]);
        ArrayList<int[]> ans = new ArrayList<>();
        int[] temp = intervals[0];
        ans.add(temp);

        if (length==1) return ans.toArray(new int[ans.size()][2]);

        for (int i = 1; i < length; i++) {
            int[] now = intervals[i];

            if (now[0]>temp[1]){
                ans.add(now);
                temp=now;
            }

            temp[0]=Math.min(temp[0],now[0]);
            temp[1]=Math.max(temp[1],now[1]);
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}
