package Sequence;

public class Test0541 {
}

class Solution0541_1 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();

        int step = k * 2,len=chars.length,index=0;
        for (; index < len; index+=step)
            reverseString(chars,index, Math.min(index + k - 1, len - 1));

        reverseString(chars,index-step,len-index>k?index+k-1:len-1);

        return new String(chars);
    }

    public void reverseString(char[] s, int i, int j) {
        while (i < j) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
}
