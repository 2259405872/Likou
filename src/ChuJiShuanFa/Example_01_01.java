package ChuJiShuanFa;

public class Example_01_01 {
    public int removeDuplicates(int[] nums) {
        int j=1;
        int n=nums[0];
        for (int i:nums) {
            if (i!=n) {
                nums[j]=i;
                j++;
                n=i;
            }
        }
        return j;
    }
}
