package Sequence;

import java.util.LinkedList;

public class Test0316 {
    public static void main(String[] args) {
        new Solution0316_1().removeDuplicateLetters("ecbacba");
    }
}

class Solution0316_1 {
    public String removeDuplicateLetters(String s) {
        int[] counts = new int[26];
        boolean[] record = new boolean[26];
        char[] chars = s.toCharArray();

        for (char c : chars) counts[c-'a']++;

        StringBuilder ans = new StringBuilder();
        LinkedList<Character> characters = new LinkedList<>();
        for (char c : chars) {
            int index = c - 'a';

            if (!record[index]){
                while (characters.size()>0) {
                    Character peek = characters.peekLast();
                    if (peek>c&&counts[peek-'a']>0){
                        Character remove = characters.removeLast();
                        record[remove-'a']=false;
                    }else break;
                }

                characters.offer(c);
                record[index]=true;
            }

            counts[index]--;
        }

        for (Character character : characters) ans.append(character);

        return ans.toString();
    }
}