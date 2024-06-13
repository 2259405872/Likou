package Sequence;

public class Test0080 {

}

class Solution0080_1 {
    public int removeDuplicates(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        boolean b=true;
        int result=0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]!=nums[result]){
                nums[++result]=nums[i];
                b=true;
            } else if (b) {
                nums[++result]=nums[i];
                b=false;
            }
        }
        return result+1;
    }
}
