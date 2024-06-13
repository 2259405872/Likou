package Sequence;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Test0936 {
    public static void main(String[] args) {
        new Solution0936_1().movesToStamp("abc","ababc");
    }
}

class Solution0936_1 {
    public int[] movesToStamp(String stamp, String target) {
        char[] stampChars = stamp.toCharArray();
        char[] targetChars = target.toCharArray();

        Deque<int[]> deque = new LinkedList<>();

        char flag='.';
        int[] now = new int[2];
        for (int i = 0; i < targetChars.length; i++) {
            char targetChar = targetChars[i];

            if (flag!=targetChar) {

                int stampIndex=-1;
                int startIndex;
                do {
                    stampIndex = stamp.indexOf(targetChar,stampIndex+1);
                    startIndex = i - stampIndex;
                } while (!(startIndex+stampChars.length-1<targetChars.length)&&stampIndex!=-1);

                if (startIndex<0||stampIndex==-1) return new int[0];
                now=new int[]{startIndex,i};


                if (deque.isEmpty()||startIndex==i){
                    deque.addLast(now);
                }else {
                    Deque<int[]> temp = new LinkedList<>();
                    temp.push(deque.removeLast());
                    while (!deque.isEmpty()&& startIndex >temp.peek()[1]) temp.push(deque.removeLast());
                    while (!deque.isEmpty()&& startIndex <=deque.peekLast()[1]) temp.push(deque.removeLast());

                    deque.offer(now);
                    flag=stampIndex+1<stampChars.length?stampChars[stampIndex+1]:'.';
                    deque.addAll(temp);
                    continue;
                }
            }else {
                now[1]=i;
            }
            flag=now[1]-now[0]+1<stampChars.length?stampChars[now[1]-now[0]+1]:'.';
        }

        int[] ans = new int[deque.size()];
        for (int i = 0; !deque.isEmpty(); i++) ans[i]=deque.poll()[0];

        return ans;
    }
}
