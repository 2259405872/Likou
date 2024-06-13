package Sequence;

import java.util.*;

public class Test0020 {
    public static void main(String[] args) {
        System.out.println(new Solution0020_4().isValid("([)]"));;
    }
}

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

        有效字符串需满足：

        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        每个右括号都有一个对应的相同类型的左括号。


        示例 1：

        输入：s = "()"
        输出：true
        示例 2：

        输入：s = "()[]{}"
        输出：true
        示例 3：

        输入：s = "(]"
        输出：false*/

class Solution0020_1 {
    public boolean isValid(String s) {
        boolean result = true;
        Stack<Character> stack = new Stack<>();
        s=s.replace('(', (char) 0);
        s=s.replace(')', (char) 1);
        s=s.replace('{', (char) 2);
        s=s.replace('}', (char) 3);
        s=s.replace('[', (char) 4);
        s=s.replace(']', (char) 5);
        for (char c : s.toCharArray()) {
            if (c%2==0){
                stack.push(c);
            }else {
                if (stack.size()==0||c-stack.pop()!=1){
                    return false;
                }
            }
        }

        if (stack.size()!=0){
            result=false;
        }
        return result;
    }
}

class Solution_second {
    public boolean isValid(String s) {
        if (s.length()%2==1) return false;
        boolean result=true;
        Stack<Character> stack=new Stack<>();

        for (char c : s.toCharArray()) {
            if (c=='('||c=='['||c=='{'){
                stack.push(c);
            }else {
                if (stack.size()==0) return false;
                char top = stack.pop();
                if(!((top == '{' && c == '}') || (top == '[' && c == ']') || (top == '(' && c == ')'))) return false;
            }
        }
        result= (stack.size()==0);
        return result;
    }
}

class Solution0020_3 {
    public boolean isValid(String s) {
        if (s.length()%2==1) return false;
        boolean result=true;
        Stack<Character> stack=new Stack<>();

        for (char c : s.toCharArray()) {
            if (c=='('||c=='['||c=='{'){
                stack.push(c);
            }else {
                if (stack.size()==0) return false;
                char top = stack.pop();
                if(!((top == '{' && c == '}') || (top == '[' && c == ']') || (top == '(' && c == ')'))) return false;
            }
        }
        result= (stack.size()==0);
        return result;
    }
}

class Solution0020_4 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();

        Character p = null;
        for (char c : chars) {
            if (c=='('||c=='['||c=='{')stack.offer(c);
            else if ((p=stack.pollLast())==null
                    ||c-p>2||c-p<1) return false;
        }
        return stack.isEmpty();
    }
}

class Solution0020_5 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>(chars.length);

        for (char c : chars) {
            if (c=='('||c=='['||c=='{') stack.offer(c);
            else if (stack.isEmpty()) return false;
            else if (c==')' && stack.pollLast()!='(') return false;
            else if (c==']' && stack.pollLast()!='[') return false;
            else if (c=='}' && stack.pollLast()!='{') return false;
        }

        return stack.isEmpty();
    }
}