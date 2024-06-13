package Sequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test0049 {
}

class Solution0049_1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<Integer, Integer> map = new HashMap<>();
        for (String str : strs) {
            int sum=0;
            char[] chars = str.toCharArray();

            for (char c : chars) {
                sum += (int)c*(int)c*(int)c*(int)c;
            }
            int index = map.getOrDefault(sum, -1);
            if (index!=-1){
                result.get(index).add(str);
            }else {
                map.put(sum, result.size());
                ArrayList<String> strings = new ArrayList<>();
                strings.add(str);
                result.add(strings);
            }
        }

        return result;
    }
}

class Solution0049_2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> ans = new ArrayList<>();

        int count=0;
        Map<Integer, Integer> map = new HashMap<>();
        for (String str : strs) {
            int hash = 1;
            for (char c : str.toCharArray()) hash+=c*c*c*c;

            Integer index = map.get(hash);
            if (index == null){
                index=count++;
                map.put(hash, index);
                ans.add(new ArrayList<String>());
            }

            ans.get(index).add(str);
        }

        return ans;
    }
}
