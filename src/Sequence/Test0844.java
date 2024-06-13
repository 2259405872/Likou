package Sequence;

public class Test0844 {
}

class Solution0844_1 {
    public boolean backspaceCompare(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        int count1 = getCount(chars1);
        int count2 = getCount(chars2);

        if (count1 != count2) return false;
        for (int i = 0; i < count1; i++) if (chars1[i] != chars2[i]) return false;

        return true;
    }

    public int getCount(char[] chars){
        int length = chars.length;
        int count = 0;

        for(int i=0; i<length; i++)
            if(chars[i]!='#')chars[count++]=chars[i];
            else if (count>0) count--;

        return count;
    }


}
