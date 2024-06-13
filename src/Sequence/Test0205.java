package Sequence;

import java.util.HashMap;
import java.util.Map;

public class Test0205 {
    public static void main(String[] args) {
        new Solution0205_1().isIsomorphic("badc","baba");
    }
}

class Solution0205_1 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map1=new HashMap<>();
        Map<Character,Character> map2=new HashMap<>();
        char[] charS = s.toCharArray();
        char[] charsT = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char sc = charS[i];
            char tc = charsT[i];
            Character c1 = map1.get(sc);
            Character c2 = map2.get(tc);

            if (c1==null&&c2==null) {
                map1.put(sc, tc);
                map2.put(tc, sc);
                continue;
            }

            if (c1==null||c2==null||c1 != tc||c2 !=sc) return false;
        }

        return true;
    }
}
