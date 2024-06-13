package Sequence;

import java.util.ArrayList;
import java.util.List;

public class Test0228 {
}

class Solution0228_1 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;
        int start =nums[0],end =nums[0],temp =start-1;
        StringBuilder s = new StringBuilder();
        for (int num : nums) {
            if (temp!=num-1){
                s.append(start);
                if (start!=end) s.append("->").append(end);
                result.add(s.toString());
                s.setLength(0);

                start=num;
                end=num;
            }else{
                end=num;
            }

            temp=num;
        }

        s.append(start);
        if (start!=end) s.append("->").append(end);
        result.add(s.toString());

        return result;
    }
}