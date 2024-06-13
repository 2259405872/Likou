package ChuJiShuanFa;

import java.util.HashSet;

public class Example_01_04 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }
}
