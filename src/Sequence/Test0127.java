package Sequence;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class Test0127 {
}

class Solution0127_1 {

    List<String> wordList;
    int[] du;
    Deque<String> temp;
    String endWord;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (Objects.equals(beginWord, this.endWord)) return 0;

        int result=1;
        this.du=new int[wordList.size()];
        this.wordList = wordList;
        this.endWord = endWord;

        Deque<String> deque=new ArrayDeque<>();
        temp=new ArrayDeque<>();
        deque.offer(beginWord);

        while (!deque.isEmpty()){
            for (String start : deque) {
                if (traversal(start)) return result;
                deque.poll();
            }

            deque=temp;
            temp=new ArrayDeque<>();
            result++;

        }

        return 0;
    }

    public boolean traversal(String start){
        if (Objects.equals(start, endWord)) return true;

        int size = wordList.size();
        for (int i = 0; i< size; i++){
            String end = wordList.get(i);
            if (du[i]==0&&canChange(start, end)){
                du[i]++;
                temp.offer(end);
            }
        }

        return false;
    }

    public boolean canChange(String start, String result){
        int count=0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i)!=result.charAt(i)) count++;
        }

        return count==1;
    }

}