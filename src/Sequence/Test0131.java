package Sequence;

import java.util.ArrayList;
import java.util.List;

public class Test0131 {
}


class Solution0131_01 {
    List<List<String>> ans=new ArrayList<>();
    public List<List<String>> partition(String s) {
        bfs(s.toCharArray(),new ArrayList<>(),0);

        return ans;
    }

    public boolean ishuiwen(char[] chars,int start,int end) {
        for (;start<end;start++,end--) if (chars[start]!=chars[end]) return false;
        return true;
    }

    public void bfs(char[] chars,ArrayList<String> list,int start){
        int length = chars.length;
        if(length==start) ans.add(new ArrayList<>(list));

        for (int i = start+1; i <= length; i++) {
            if (ishuiwen(chars,start,i-1)){
                list.add(String.valueOf(chars,start,i-start));
                bfs(chars,list,i);
                list.remove(list.size()-1);
            }
        }
    }
}