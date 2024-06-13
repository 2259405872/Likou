package Sequence;

import java.util.ArrayDeque;

public class Test0151 {
}

class Solution0151_1 {
    public String reverseWords(String s) {

        ArrayDeque<String> deque = new ArrayDeque<>();
        int len = s.length();
        boolean flag=false;
        int start=0,end=0;
        for (int i = 0; i <len; i++) {
            if (s.charAt(i)!=' '&&!flag) {
                start = i;
                flag=true;
            }
            if (s.charAt(i)==' '&&flag){
                end = i;
                deque.push(s.substring(start, end));
                flag=false;
            }
        }
        if (flag){
            deque.push(s.substring(start, len));
        }

        return String.join(" ", deque);
    }
}


class Solution151_2 {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        //1.去掉前后空格
        int right=0,left=0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i)!=' '){
                right = i;
                break;
            }
        }
        left=getLeft(s,left=len-1,right=right);

        //2.开始循环
        while (left>right){
            int index=left;
            //2.1寻找单词开头
            while (s.charAt(index)!=' '&&index>right){
                index--;
            }
            //最后一个单词最后单独加
            if(index==right){
                break;
            }
            //2.2追加进入builder
            result.append(s.substring(index+1,left+1));
            result.append(" ");
            left=getLeft(s,index,right);
        }
        result.append(s.substring(right,left+1));
        return result.toString();
    }

    public static int getLeft(String s, int left, int right) {
        for (int i = left; i >=right; i--) {
            if (s.charAt(i)!=' '){
                left=i;
                break;
            }
        }
        return left;
    }
}
