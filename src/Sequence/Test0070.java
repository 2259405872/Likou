package Sequence;

import java.util.ArrayDeque;
import java.util.Stack;

public class Test0070 {
    public static void main(String[] args) {
        System.out.println( new Solution0070_1().climbStairs(38));;
    }
}

class Solution0070_1 {
    public int climbStairs(int n) {
        int ans = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.push(n);
        int flag=n;
        while (!deque.isEmpty()||flag>=0) {
            if (flag<=0){
                if (flag==0)ans++;
                flag=deque.poll()-2;
            }else {
                --flag;
            }
            if(flag>0) deque.offer(flag);
        }
        return ans;
    }
}

class Solution0070_2 {
    public int climbStairs(int n) {
        int ans = 1,subOne = 0,subTwo = 0;
        for (int i = 1; i <= n; i++) {
            subTwo=subOne;
            subOne=ans;

            ans=subOne+subTwo;
        }

        return ans;
    }
}

class Solution0070_3 {
    public int climbStairs(int n) {
        int pre2=0,pre1=0,now=1;

        for (int i = 1; i <= n; i++) {
            pre2=pre1;
            pre1=now;

            now=pre2+pre1;
        }

        return now;
    }
}