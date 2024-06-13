package Sequence;

public class Test0459 {

}

class Solution0459_1 {
    public boolean repeatedSubstringPattern(String s) {
        char[] chars1 = s.toCharArray();
        int length = chars1.length;
        int[] pre = new int[length];

        for (int j=0,i = 1; i < length; i++) {
            while (chars1[i] != chars1[j]&&j>0) j=pre[j-1];

            if (chars1[i] == chars1[j]) j++;

            pre[i] = j;
        }

        return pre[length-1]>0 &&length%(length-pre[length-1])==0;
    }
}
