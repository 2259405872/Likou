package Sequence;

public class Test0300 {
}

class Solution0300_1 {
    public int lengthOfLIS(int[] nums) {
        int result=1;
        int length = nums.length;
        if (length==1)  return result;

        int[] record = new int[length];
        record[0]=1;

        for (int i = 1; i < length; i++) {
            record[i]=1;
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]){
                    record[i]=Math.max(record[i],record[j]+1);
                }
            }
            result=Math.max(record[i],result);
        }

        return result;
    }
}

class Solution0300_2 {
    public int lengthOfLIS(int[] nums) {
        int ans=0;
        int length = nums.length;
        int[] records = new int[length];
        records[0] = 1;
        for (int i = 1; i < length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) if (nums[j]<nums[i]) max = Math.max(max,records[j]);
            records[i] = max+1;
            ans = Math.max(ans,max+1);
        }

        return ans;
    }
}
