package Sequence;

import java.util.ArrayList;
import java.util.List;

public class Test0118 {
}


class Solution0118_1 {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> ans = new ArrayList<>();

        ArrayList<Integer> pre = new ArrayList<>();
        pre.add(1);
        ans.add(pre);

        int size;
        while ((size=pre.size()) < numRows) {
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i <= size; i++) {
                int l= i>0?pre.get(i-1):0;
                int r= i<size?pre.get(i):0;

                list.add(l+r);
            }

            ans.add(list);
            pre = list;
        }

        return ans;
    }
}