package ChuJiShuanFa;


public class Example_01_05 {
    public int singleNumber(int[] nums) {
        int reduce=0;
        for (int i : nums) {
            reduce=reduce^i;
        }
        return reduce;
    }
}
