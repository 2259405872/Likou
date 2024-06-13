package Sequence;

public class Test0349 {
}

class Solution0349_1 {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] ints = new boolean[1002];
        boolean[] records = new boolean[1002];

        for (int num1 : nums1) ints[num1] = true;
        int count=0;
        for (int num2 : nums2)
            if (!records[num2]&&(records[num2] = ints[num2])) count++;

        int[] ans = new int[count];
        int index = 0;
        for (int i = 0; i < records.length&&index<count; i++)
            if (records[i]) ans[index++] = i;

        return ans;
    }
}
