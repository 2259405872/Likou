package ShuJuJieGou_easy;

import java.util.HashSet;

public class Practice01 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for (int n:nums) {
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }
}
