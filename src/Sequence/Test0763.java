package Sequence;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test0763 {
}

class Solution0763_1 {
    public List<Integer> partitionLabels(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();

        int[] records = new int[26];
        Arrays.fill(records,-1);

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            int record = records[chars[i] - 'a'];

            if (record != -1)
                while (!ans.isEmpty()&&record<=ans.get(ans.size()-1))
                    ans.remove(ans.size()-1);
            else
                records[chars[i] - 'a'] = i;

            ans.add(i);
        }

        int size = ans.size();
        for (int i = size-1;i>0; i--) ans.set(i,ans.get(i)-ans.get(i-1));
        ans.set(0,ans.get(0)+1);

        return ans;
    }
}
