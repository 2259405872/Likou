package Sequence;

public class Test0028 {
    public static void main(String[] args) {
        new Solution0028_3().strStr("mississippi","issipi");
    }
}
/*

    给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。



        示例 1：

        输入：haystack = "sadbutsad", needle = "sad"
        输出：0
        解释："sad" 在下标 0 和 6 处匹配。
        第一个匹配项的下标是 0 ，所以返回 0 。
        示例 2：

        输入：haystack = "leetcode", needle = "leeto"
        输出：-1
        解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
*/

class Solution0028_1 {
    public int strStr(String haystack, String needle) {
        int result =-1;
        haystack=haystack.replace(needle,"*");
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == '*'){
                result=i;
                break;
            }
        }
        return result;
    }

}

class Solution0028_second {
    public int strStr(String haystack, String needle) {
        boolean flag =false;
        int temp =-1;
        int count=0;
        int index=0;
        int len1 = haystack.length();
        int len2 = needle.length();
        int[] next=new int[len2];

        for (int j=0,i = 1; i < len2; i++) {
            while (needle.charAt(j)!=needle.charAt(i)&&j>0){
                j=next[j-1];
            }

            if (needle.charAt(j)==needle.charAt(i)){
                j+=1;
            }
            next[i]=j;
        }

        for (int i = 0; i < len1; i++) {


            if(!flag){
                if (haystack.charAt(i) == needle.charAt(0)){
                    flag=true;
                    temp=i;
                    count+=1;
                    index=1;
                }
            }else {
                if (haystack.charAt(i) == needle.charAt(count)){
                    index=next[count];
                    count++;
                }else {
                    count=index;
                    if(count==0){
                        flag=false;
                    }
                    temp=i-count;
                    index=next[count-1];
                    i=i-1;
                }
            }

            if (count==len2){
                return temp;
            }
        }
        return -1;
    }

}

class Solution0028_3 {
    public int strStr(String haystack, String needle) {
        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();
        int len1 = chars1.length,len2 = chars2.length;

        int[] pre = new int[len2];
        for (int j=0,i = 1; i < len2; i++) {
            while (chars2[j]!=chars2[i]&&j>0)
                j=pre[j-1];

            if (chars2[j]==chars2[i]) j++;
            pre[i]=j;
        }

        int count=0,ans=-1;
        for (int i = 0; i < len1; i++) {
            if (chars1[i]==chars2[count]){
                if (ans==-1) ans=i;
                if (++count==len2) return ans;
            } else if (ans!=-1){
                while (chars1[i]!=chars2[count]&&count>0)
                    count=pre[count-1];

                if (chars1[i]==chars2[count]) ans=i-count++;
                else ans=-1;
            }

        }

        return -1;
    }
}