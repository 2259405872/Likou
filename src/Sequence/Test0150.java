package Sequence;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Test0150 {
    public static void main(String[] args) {
        new Solution0150_2().evalRPN(new String[]{"4","13","5","/","+"});
    }
}

class Solution0150_1 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int current=Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i++) {
            if(tokens[i].equals("+")){
                int temp=stack.pop();
                current+=temp;
            }else if(tokens[i].equals("-")){
                int temp=stack.pop();
                current=temp-current;
            }else if(tokens[i].equals("*")){
                int temp=stack.pop();
                current*=temp;
            }else if(tokens[i].equals("/")){
                int temp=stack.pop();
                current=temp/current;
            }else {
                stack.push(current);
                current=Integer.parseInt(tokens[i]);
            }
        }

        return current;
    }
}

class Solution0150_2 {
    public int evalRPN(String[] tokens) {
        if(tokens.length<1) return 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    deque.push(deque.poll() + deque.poll());
                    break;
                case "-":
                    deque.push(-deque.poll() + deque.poll());
                    break;
                case "*":
                    deque.push(deque.poll() * deque.poll());
                    break;
                case "/":
                    Integer poll1 = deque.poll();
                    Integer poll2 = deque.poll();
                    deque.push(poll2/poll1);
                    break;
                default:
                    deque.push(Integer.valueOf(token));
                    break;
            }
        }

        return deque.poll();
    }
}