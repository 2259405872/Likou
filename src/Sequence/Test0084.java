package Sequence;

import java.util.ArrayDeque;

public class Test0084 {
    public static void main(String[] args) {
        new Solution0084_1().largestRectangleArea(new int[]{2,4});
    }
}

class Solution0084_1 {
    public int largestRectangleArea(int[] heights) {
        int ans=heights[0];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.offer(-1);

        int lastIndex;
        int height=ans;
        for (int i = 0; i < heights.length; i++) {
            height = heights[i];

            while ((lastIndex=deque.peekLast())!=-1&& height < heights[lastIndex]) {
                int curHeight = heights[deque.pollLast()];

                while ((lastIndex=deque.peekLast())!=-1&&curHeight<=heights[lastIndex]) deque.pollLast();

                ans=Math.max(ans,curHeight*(i-lastIndex-1));
            }

            deque.offer(i);
        }

        int i= heights.length;
        height=Integer.MIN_VALUE;
        while (i!=-1){
            while ((lastIndex=deque.peekLast())!=-1&& height < heights[lastIndex]) {
                int curHeight = heights[deque.pollLast()];

                while ((lastIndex=deque.peekLast())!=-1&&curHeight<=heights[lastIndex]) deque.pollLast();

                ans=Math.max(ans,curHeight*(i-lastIndex-1));
            }

            i= deque.pollLast();
            if (i!=-1) height=heights[i];
        }

        return ans;
    }
}
