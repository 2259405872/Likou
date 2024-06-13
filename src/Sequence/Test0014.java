package Sequence;

public class Test0014 {
}


/*
编写一个函数来查找字符串数组中的最长公共前缀。

        如果不存在公共前缀，返回空字符串 ""。



        示例 1：
        输入：strs = ["flower","flow","flight"]
        输出："fl"
        示例 2：
        输入：strs = ["dog","racecar","car"]
        输出：""
        解释：输入不存在公共前缀。
*/

class Solution0014_1 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result= new StringBuilder();
        boolean b=true;
        int i=0;
        char c;
        while (b){
            if (strs[0].length()<i+1){
                break;
            }
            c=strs[0].charAt(i);
            for (int j=1;j<strs.length;j++) {
                if (strs[j].length()<i+1||strs[j].charAt(i)!=c) {
                    b=false;
                    break;
                }
            }
            if (b){
                result.append(c);
                i++;
            }
        }
        return result.toString();
    }
}

class Solution0014_2 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";
        //公共前缀比所有字符串都短，随便选一个先
        String s=strs[0];
        for (String string : strs) {
            while(!string.startsWith(s)){
                if(s.length()==0)return "";
                //公共前缀不匹配就让它变短！
                s=s.substring(0,s.length()-1);
            }
        }
        return s;
    }
}

class Solution0014_second {
    public String longestCommonPrefix(String[] strs) {
        String ans=strs[0];
        for (int i = 1; i <strs.length; i++) {
            String str = strs[i];
            int j = 0;
            for (; j <ans.length()&&j<str.length(); j++) {
                if (ans.charAt(j)!=str.charAt(j)) {
                    break;
                }
            }

            ans=ans.substring(0,j);
            if (ans.length()==0)return ans;
        }

        return ans;
    }

}