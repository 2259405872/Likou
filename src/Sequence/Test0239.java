package Sequence;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Test0239 {
    public static void main(String[] args) {
        new Solution0239_1().maxSlidingWindow(new int[]{9,10,9,-7,-4,-8,2,-6},5);

    }
}
class Solution0239_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] ans = new int[length - k + 1];

        LinkedList<Integer> list = new LinkedList<>();
        int maxIndex = 0;
        for (int i = 1; i < k; i++){
            insertList(list,nums,i);
            if (nums[maxIndex]<=nums[i]){
                maxIndex=i;
                list.clear();
            }
        }

        ans[0]=nums[maxIndex];
        for (int i = k; i < length; i++) {
            insertList(list,nums,i);

            if (i-k>=maxIndex) maxIndex=list.pop();

            if (nums[maxIndex]<=nums[i]){
                maxIndex=i;
                list.clear();
            }

            ans[i-k+1]=nums[maxIndex];
        }

        return ans;
    }

    public void insertList(LinkedList<Integer> list, int[] nums,int index){
        while (!list.isEmpty())
            if (nums[list.peekLast()]<=nums[index])
                list.removeLast();
            else break;
        list.offer(index);
    }
}

class Solution0239_2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] ans = new int[length - k + 1];

        Deque<Integer> deque = new LinkedList<>();
        int l=0,r=-1;
        while (++r<k)
            insert(deque,nums[r]);

        for (;r<length;r++,l++){
            ans[l] = deque.peek();

            if (deque.peek()==nums[l])
                deque.poll();
            insert(deque,nums[r]);
        }
        ans[l] = deque.peek();

        return ans;
    }

    public void insert(Deque<Integer> deque, int now) {
        if (deque.isEmpty()||now>deque.peek())
            deque.clear();
        else
            while (now>deque.peekLast())
                deque.pollLast();

        deque.offer(now);
    }
}