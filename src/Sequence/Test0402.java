package Sequence;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Test0402 {
    public static void main(String[] args) {
        new Solution0402_1().removeKdigits("112",1);
    }
}


class Solution0402_1 {
    public String removeKdigits(String num, int k) {
        int length = num.length();
        if (length<=k) return "0";
        char[] chars = num.toCharArray();

        StringBuilder ans = new StringBuilder();

        for (int index = 0; index < length-k; index++) {
            int end=k+index;
            int min=index;

            for (int i = index+1; i <=end; i++) {
                if (chars[i]<chars[min]) min=i;
            }

            if (ans.length()!=0||chars[min]!='0') ans.append(chars[min]);
            k-=min-index;
            index=min;
        }

        String result = ans.toString();
        result=result.length()==0?"0":result;
        return result;
    }
}

class Solution0402_2 {
    public String removeKdigits(String num, int k) {
        int length = num.length();
        char[] chars = num.toCharArray();

        LinkedList<Character> stack = new LinkedList<>();
        for (char c:chars) {
            while (stack.size()>0&&k>0){
                char peek = stack.peek();
                if (peek<=c) break;
                stack.pop();
                k--;
            }

            if (stack.size() !=0|| c!='0') stack.push(c);
        }

        int size=stack.size();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<size-k;i++) stringBuilder.append(stack.removeLast());
        return stringBuilder.length()!=0?stringBuilder.toString():"0";
    }
}