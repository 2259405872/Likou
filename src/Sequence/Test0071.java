package Sequence;

public class Test0071 {
}

class Solution0071_1 {
    public String simplifyPath(String path) {
        char[] chars = path.toCharArray();
        int index = 0,l=0,r=0,len=chars.length;
        while (++r<len) {
            int count=0;

            while (r<len&&chars[r]!='/') {
                if (chars[r++]=='.') count++;
            }

            if (count+l+1!=r||count>2){
                while (l<r){
                    chars[index++]=chars[l++];                }
            }else if(count==2){
                while (index>0&&chars[--index]!='/'){}
            }
            l=r;
        }
        return new String(chars, 0, index == 0 ? 1 : index);
    }
}
