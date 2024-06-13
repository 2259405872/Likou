package Sequence;


import java.util.HashMap;
import java.util.Map;

public class Test0005 {
    public static void main(String[] args){
        new Solution0005_3().longestPalindrome("aba");
    }
}

/*
    给你一个字符串 s，找到 s 中最长的回文子串。

        如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。



        示例 1：

        输入：s = "babad"
        输出："bab"
        解释："aba" 同样是符合题意的答案。
        示例 2：

        输入：s = "cbbd"
        输出："bb"
*/

class Solution0005_1 {
    public String longestPalindrome(String s) {
        String result= "";
        Map<Character,Integer> map=new HashMap<Character,Integer>();//通过map存储最新字符的位置
        int left=-1;//回文子串开始的下标
        int right=-1;//回文子串结束的下标
        char c;
        boolean b=false;//记录满不满足回文子串的条件
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i))!=null){
                //前面出现过这个字母，开始判断

                //1.判断，满不满足回文子串的基本的条件，aba式对称或aa式对称,并得到左右开始下标
                left = map.get(s.charAt(i));
                //同字母子串，在检测回文数时完全可以看成一个字符，因此
                //当遇到同字母子串时，要将同字母子串的左边和右边，作为左下标和右下标开始检验回文子串
                if(i-left==1){
                    //相同字母相邻，可能是多个同字符相邻，这时先将下标i移到同字母子串的最右边
                    c=s.charAt(i);
                    right=i;
                    for (int j = i; j < s.length(); j++) {
                        if (s.charAt(j)!=c){
                            i=j-1;
                            right=j-1;
                            break;
                        }
                        if(j==s.length()-1){
                            i=j;
                            right=j;
                        }
                    }
                    map.put(c,right);//刷新map
                    b=true;
                } else if (i - left == 2) {
                    //相同字母不相邻，这时直接检测回文子串
                    right=i;
                    map.put(s.charAt(i),i);
                    b=true;
                }else {
                    map.put(s.charAt(i),i);
                }

                //2.移动左右下标，得到回文子串的开始和终点
                while (b&&left>0&&right<s.length()-1){
                    if (s.charAt(left-1)!=s.charAt(right+1)){
                        b=false;
                    }else {
                        right++;
                        left--;
                    }
                }

                //3.判断这个子串是否比当前子串长，考虑是否替换
                if (right-left>result.length()-1){
                    result=s.substring(left, right+1);
                }

                right=-1;
            }else{
                map.put(s.charAt(i),i);
            }
        }

        if (result.length()==0&&s.length()!=0){
            result=""+s.charAt(0);
        }
        return result;
    }
}

class Solution0005_2 {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length==1) return s;

        int max=0;
        int maxI=0, maxJ=0;

        char[] chars = s.toCharArray();
        int[][] records = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (chars[j]==chars[i]){
                    if (j==i){
                        records[i][j]=1;
                    }else if (j==i-1) {
                        records[i][j]=2;
                    } else if (records[i - 1][j + 1] > 0) {
                        records[i][j]=records[i-1][j+1]+2;
                    }
                }else {
                    records[i][j]=0;
                }

                if (records[i][j]>max){
                    max=records[i][j];
                    maxJ=j;
                    maxI=i;
                }
            }
        }

        return s.substring(maxJ,maxI+1);
    }
}

class Solution0005_3 {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length==1) return s;

        char[] chars = s.toCharArray();
        int[] dp = new int[length];

        int start = 0, end = 0,max=1;
        for (int i = 1; i < length; i++) {
            char c1 = chars[i];
            for (int j = 0; j <= i; j++) {
                char c2 = chars[j];

                if (c1==c2){
                    if (j==i)dp[j]=1;
                    else if (j == i - 1) dp[j]=2;
                    else if (dp[j + 1] > 0) dp[j]=dp[j + 1]+2;
                    else dp[j]=0;
                }else {
                    dp[j]=0;
                }

                if (dp[j]>max){
                    max=dp[j];
                    start=j;
                    end=i;
                }
            }

        }

        return s.substring(start, end);
    }
}