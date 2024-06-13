package Sequence;

public class Test0067 {
    public static void main(String[] args) {
        String s = new Solution0067_1().addBinary("11","1");
        System.out.println(s);
    }
}

class Solution0067_1 {
    public String addBinary(String a, String b) {
        StringBuilder ans=new StringBuilder();
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int i = a.length()-1,j=b.length()-1;

        char temp='0';
        while (i>=0 || j>=0) {
            char aChar = i>=0?aChars[i]:'0';
            char bChar = j>=0?bChars[j]:'0';

            if (aChar=='0'&&bChar=='0'){
                ans.append(temp);
                temp='0';
            } else if (aChar=='1'&&bChar=='1') {
                ans.append(temp);
                temp='1';
            }else {
                if (temp=='0'){
                    ans.append('1');
                }else {
                    ans.append('0');
                }
            }
            i--;
            j--;
        }

        if (temp=='1') ans.append('1');
        return ans.reverse().toString();
    }
}
