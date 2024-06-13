package Sequence;

import java.util.HashMap;
import java.util.Objects;

public class Test0290 {

    public static void main(String[] args) {
        new Solution0290_1().wordPattern("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd"
                ,"s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t"
        );
    }

}

class Solution0290_1 {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        char[] chars = pattern.toCharArray();
        String[] strings = s.split(" ");
        if (strings.length!=chars.length) return false;

        for (int i = 0; i < strings.length; i++) {
            char c = chars[i];
            String str = strings[i];
            if (map1.get(c)==null&&map2.get(str)==null) {
                map1.put(c,i);
                map2.put(str,i);
                continue;
            }

            if (map1.get(c)==null||map2.get(str)==null|| !Objects.equals(map1.get(c), map2.get(str))) {
                return false;
            }
        }
        return true;
    }
}
