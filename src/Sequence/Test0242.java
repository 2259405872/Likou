package Sequence;

public class Test0242 {

}
class Solution0242_1 {
    public boolean isAnagram(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        if (charS.length!=charT.length) return false;
        int[] map = new int[26];
        for (char aChar : charS) {
            map[aChar - 'a']++;
        }

        for (char c : charT) {
            map[c - 'a']--;
        }
        for (int i : map) {
            if (i!=0) return false;
        }

        return true;
    }
}

class Solution0242_2 {
    public boolean isAnagram(String s, String t) {
        int[] records = new int[26];

        for (char c : s.toCharArray())
            records[c - 'a']++;

        for (char c : t.toCharArray())
            if (--records[c - 'a']<0) return false;

        for (int record : records)
            if (record != 0) return false;

        return true;

    }
}