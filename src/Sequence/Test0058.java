package Sequence;

public class Test0058 {
}
/*
给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。

单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。



示例 1：

输入：s = "Hello World"
输出：5
解释：最后一个单词是“World”，长度为5。
示例 2：

输入：s = "   fly me   to   the moon  "
输出：4
解释：最后一个单词是“moon”，长度为4。
示例 3：

输入：s = "luffy is still joyboy"
输出：6
解释：最后一个单词是长度为6的“joyboy”。
*/

class Solution0058_1 {
    public int lengthOfLastWord(String s) {
        int result=0;
        int len=s.length();
        for(len=len-1; len>-1; len--){
            if (s.charAt(len)!=' '){
                break;
            }
        }

        for (int i = len; i >-1; i--) {
            if(s.charAt(i)!=' '){
                result++;
            }else {
                break;
            }
        }
        return result;
    }
}

class Solution0058_second {
    public int lengthOfLastWord(String s) {
        int result=0;
        int len = s.length();
        boolean flag=false;
        char[] chars = s.toCharArray();
        for (int i = len-1; i >=0; i--) {
            if (!flag&&chars[i]!=' '){
                result++;
                flag=true;
            }else if(flag){
                if (chars[i]!=' '){
                    result++;
                }else {
                    break;
                }
            }
        }
        return result;
    }
}