package Sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test0018 {
}

class Solution0018_1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len=nums.length;
        int now=0;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        while (now<len-2){
            int now2=now+1;
            while (now2<len-1){
                int l=now2+1,r=len-1;
                long nowR=target-nums[now2]-nums[now];

                while (l<r){
                    int sum = nums[l]+nums[r];

                    if (sum<nowR) l=next(l,r,nums,1);
                    else if (sum > nowR) r=next(r,l,nums,-1);
                    else {
                        ans.add(List.of(nums[now],nums[now2],nums[l],nums[r]));

                        l=next(l,r,nums,1);
                        r=next(r,l,nums,-1);
                    }
                }

                now2=next(now2,l,nums,1);
            }
            now=next(now,len-1,nums,1);
        }

        return ans;
    }

    public int next(int now,int limit,int[] nums,int step) {
        int old = nums[now];
        while (now!=limit&&old==nums[now]) now+=step;
        return now;
    }
}
