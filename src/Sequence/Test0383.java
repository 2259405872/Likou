package Sequence;

public class Test0383 {
}

class Solution00383_1 {
    public boolean canConstruct(String ransomNote, String magazine) {
        ransomNote.indexOf('a',15);
        int map[]=new int[26];
        for (char c : magazine.toCharArray()) map[c-'a']++;
        for (char c : ransomNote.toCharArray()) {
            int flag=--map[c-'a'];
            if (flag<0) return false;
        }
        return true;
    }
}

class Solution0383_2 {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] chars1 = ransomNote.toCharArray();
        char[] chars2 = magazine.toCharArray();
        int[] ints = new int[26];

        for (char c : chars1) ints[c-'a']++;
        for (char c : chars2) ints[c-'a']--;
        for (int i : ints) if (i > 0) return false;

        return true;
    }
}


