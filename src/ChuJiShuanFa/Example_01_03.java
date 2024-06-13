package ChuJiShuanFa;

public class Example_01_03 {
    public void rotate(int[] nums, int k) {
        int[] newnums=new int[nums.length];
        System.arraycopy(nums, nums.length-k, newnums, 0, k);
        System.arraycopy(nums, 0, newnums, k, nums.length-k);
        System.arraycopy(newnums, 0, nums, 0, newnums.length);;
    }
}
