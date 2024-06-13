package Sequence;

import java.util.ArrayList;
import java.util.List;

public class Test0006 {
}

/*
将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：

P   A   H   N_01
A P L S I I G
Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);


示例 1：

输入：s = "PAYPALISHIRING", numRows = 3
输出："PAHNAPLSIIGYIR"
示例 2：
输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N_01
A   L S  I G
Y A   H R
P     I
示例 3：

输入：s = "A", numRows = 1
输出："A"
*/

class Solution0006_1 {
    public String convert(String s, int numRows) {
        String result = "";
        int dr=numRows*2-2;
        if (dr==0){
            return s;
        }
        StringBuilder[] sbs=new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i]=new StringBuilder();
        }

        for(int i=0;i<s.length();i++){
            int index=i%dr>dr/2? dr-i%dr:i%dr;
            sbs[index].append(s.charAt(i));
        }

        for (int i = 0; i < sbs.length; i++) {
            result+= sbs[i].toString();
        }
        return result;
    }
}

class Solution0006_2 {
    public String convert(String s, int numRows) {
        String result = "";
        int dr=numRows*2-2;
        if (dr==0){
            return s;
        }
        String[] sbs=new String[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i]="";
        }

        for(int i=0;i<s.length();i++){
            int index=i%dr>dr/2? dr-i%dr:i%dr;
            sbs[index]+=s.charAt(i);
        }

        for (int i = 0; i < sbs.length; i++) {
            result+= sbs[i];
        }
        return result;
    }

    class Solution0006_3 {
        public String convert(String s, int numRows) {
            if(numRows < 2) return s;
            List<StringBuilder> rows = new ArrayList<StringBuilder>();
            for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
            int i = 0, flag = -1;
            for(char c : s.toCharArray()) {
                rows.get(i).append(c);
                if(i == 0 || i == numRows -1) flag = - flag;
                i += flag;
            }
            StringBuilder res = new StringBuilder();
            for(StringBuilder row : rows) res.append(row);
            return res.toString();
        }
    }

    class Solution {
        public String convert(String s, int numRows) {
            StringBuilder result = new StringBuilder();
            if (numRows < 2) return s;
            StringBuilder[] rows = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
                rows[i]=new StringBuilder();
            }

            int flag=1,i=0;
            for (char c : s.toCharArray()) {
                rows[i].append(c);
                if(i == numRows-1) flag = - flag;
                i+= flag;
            }

            for (StringBuilder row : rows) result.append(row);
            return result.toString();
        }
    }

}


