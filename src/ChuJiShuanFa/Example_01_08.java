package ChuJiShuanFa;

public class Example_01_08 {
    public void moveZeroes(int[] nums) {
        int i=0;
        for (int n : nums) {
            if(n!=0){
                nums[i++]=n;
            }
        } 
        for (; i < nums.length; i++) {
            nums[i]=0;
        }
    }
}
