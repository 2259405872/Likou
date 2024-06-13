package Sequence;

public class Test0394 {
    public static void main(String[] args) {
        String s = new Solution0394_01().decodeString("100[leetcode]");
        System.out.println(s);
    }
}

class Solution0394_01 {
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < chars.length; i++){
            i=build(chars,i,builder,chars.length);
            ans.append(builder.toString());
            builder.setLength(0);
        }
        return ans.toString();
    }

    public int build(char[] chars,int start, StringBuilder builder,int length){
        int count=0;

        for (;start < length&&chars[start]<='9'&&chars[start]>='0'; start++) {
            count*=10;
            count+=chars[start]-'0';
        }

        char c;
        if(count>0) start++;
        for (; start < length&&(c=chars[start])!=']'; start++){
            if (c<='9'&&c>='0'){
                StringBuilder temp = new StringBuilder();
                start=build(chars,start,temp,length);

                builder.append(temp.toString());
            }
            else builder.append(c);
        }

        String temp = builder.toString();
        count--;

        for (;count>0;count--) builder.append(temp);


        return start;
    }
}
