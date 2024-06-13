package Sequence;

import java.util.ArrayList;
import java.util.List;

public class Test0438 {
    public static void main(String[] args) {
        new Solution0438_1().findAnagrams("cbaebabacd","abc");
    }
}

class Solution0438_1 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int pLength = p.length();
        int sLength = s.length();
        if (pLength>sLength) return ans;

        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();

        int[] pRecord = new int[26];
        int[] sRecord = new int[26];

        int count = pLength;
        for (char c : pChars) pRecord[c-'a']++;
        for (int i = 0; i < pLength; i++) {
            char c = sChars[i];
            if (pRecord[c - 'a']>sRecord[c - 'a']++) count--;
            else count++;
        }
        if (count==0) ans.add(0);

        int end = sLength-pLength;
        for (int i = 0; i < end; i++) {
            char lC = sChars[i];
            char rC = sChars[i+pLength];

            int lIndex = lC - 'a';
            int rIndex = rC - 'a';
            if (pRecord[lIndex]<sRecord[lIndex]--) count--;
            else count++;

            if (pRecord[rIndex]>sRecord[rIndex]++) count--;
            else count++;

            if (count==0) ans.add(i+1);
        }
        return ans;
    }
}
