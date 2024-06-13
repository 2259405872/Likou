package Sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test0015X {
    public static void main(String[] args) {
        new Solution0015_second().threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}

class Solution0015_1 {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int l=0, r=nums.length-1;
        while (l<r-1&&nums[l]<=0&&nums[r]>=0){
            if (nums[l]+nums[r]<=0){
                if (nums[l]+nums[r-1]+nums[r]>=0){
                    for (int i = r-1; i > l; i--) {
                        if (nums[i]+nums[l]+nums[r]==0){
                            ArrayList<Integer> integers = new ArrayList<>();
                            integers.add(nums[l]);
                            integers.add(nums[r]);
                            integers.add(nums[i]);
                            result.add(integers);
                            break;
                        } else if (nums[i]+nums[l]+nums[r]<0) {
                            break;
                        }
                    }
                }
                int temp=l;
                l++;
                for (; l < r; ++l) {
                    if (nums[l]!=nums[temp]){
                        break;
                    }
                }
            }else {
                if (nums[l]+nums[l+1]+nums[r]<=0){
                    for (int i = l+1; i < r; i++) {
                        if (nums[i]+nums[l]+nums[r]==0){
                            ArrayList<Integer> integers = new ArrayList<>();
                            integers.add(nums[l]);
                            integers.add(nums[r]);
                            integers.add(nums[i]);
                            result.add(integers);
                            break;
                        } else if (nums[i]+nums[l]+nums[r]>0) {
                            break;
                        }
                    }
                }

                int temp=r;
                r--;
                for (; r > l; r--) {
                    if (nums[r]!=nums[temp]){
                        break;
                    }
                }
            }
        }

        return result;
    }
}

class Solution0015_second {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len1 = nums.length;
        int i = 0;
        Arrays.sort(nums);
        while (nums[i]<=0&&i<len1-2) {
            int l=i+1;
            int r= len1 -1;
            while (l<r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum ==0){
                    result.add(List.of(nums[i],nums[l],nums[r]));
                    r=remove_l(r,l,nums);
                } else if (sum >0) {
                    r=remove_l(r,l,nums);
                }else {
                    l=remove_r(l,r,nums);
                }
            }
            i=remove_r(i,len1-2,nums);
        }

        return result;
    }

    public static int remove_r(int star,int limt,int[]nums){
        int temp=nums[star];

        for(;star<=limt;star++){
            if(temp!=nums[star]){
                return star;
            }
        }
        return star;
    }

    public static int remove_l(int star,int limt,int[]nums){
        int temp=nums[star];

        for(;star>=limt;star--){
            if(temp!=nums[star]){
                return star;
            }
        }
        return star;
    }
}

class Solution0015_3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        int length = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < length-2; i=next(i,length-2,nums,1)) {
            int l=i+1,r=length-1,now=nums[i];
            while (l<r){
                int numL = nums[l],numR = nums[r];
                int sum = numR + numL + now;

                if (sum<0) l=next(l,r,nums,1);
                else if (sum > 0) r=next(r,l,nums,-1);
                else {
                    ans.add(List.of(now,l,r));
                    l=next(l,r,nums,1);
                }
            }
        }

        return ans;
    }

    public int next(int now,int limit,int[] nums,int step){
        int old = nums[now];
        for (; now != limit; now+=step) {
            if (nums[now]!=old) return now;
        }

        return now;
    }
}

class Solution0015_4 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len=nums.length;
        int now=0;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        while (now<len-1){
            int l=now+1,r=len-1,nowR=-nums[now];

            while (l<r){
                int sum = nums[l]+nums[r];

                if (sum<nowR) l=next(l,r,nums,1);
                else if (sum > nowR) r=next(r,l,nums,-1);
                else {
                    ans.add(List.of(nums[now],nums[l],nums[r]));

                    l=next(l,r,nums,1);
                    r=next(r,l,nums,-1);
                }
            }

            now=next(now,l,nums,1);
        }

        return ans;
    }

    public int next(int now,int limit,int[] nums,int step) {
        int old = nums[now];
        while (now!=limit&&old==nums[now]) now+=step;
        return now;
    }
}