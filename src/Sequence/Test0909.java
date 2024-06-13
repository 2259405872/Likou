package Sequence;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test0909 {
    public static void main(String[] args) {
        new Solution0909_1().snakesAndLadders(new int[][]{
                {-1,-1,27,13,-1,25,-1},
                {-1,-1,-1,-1,-1,-1,-1},
                {44,-1,8,-1,-1,2,-1},
                {-1,30,-1,-1,-1,-1,-1},
                {3,-1,20,-1,46,6,-1},
                {-1,-1,-1,-1,-1,-1,29},
                {-1,29,21,33,-1,-1,-1}
        });
    }
}

class Solution0909_1 {
    int n;
    int[][] board;
    Deque<Integer> queue;
    Deque<Integer> temp;


    int result=0;
    public int snakesAndLadders(int[][] board) {
        this.board=board;
        n= board.length;
        queue=new ArrayDeque<>();
        temp=new ArrayDeque<>();

        if (n<=1) return result;

        queue.add(1);
        while (!queue.isEmpty()){
            result++;
            for (Integer index : queue) {
                if (traversal(index)) return result;
            }
            queue=temp;
            temp=new ArrayDeque<>();
        }

        return -1;
    }

    public boolean traversal(int index) {
        //单次经过步数不大于6
        int count = 1;
        index++;

        //计算行列坐标
        int r = n - 1 - (index - 1) / n;
        int c = (n - 1 - r) % 2 == 0 ? (index - 1) % n : n - 1 - ((index - 1) % n);

        int flag = (n - 1 - r) % 2 == 0 ? 1 : -1;
        int end=index,e=index;
        for ( ;r >= 0; r--) {
            for (; c < n && c >= 0; c += flag) {
                int chess = board[r][c];
                if (chess >=0){
                    if (chess==n*n) return true;
                    temp.offer(chess);
                    board[r][c] = -2;
                } else if (chess ==-1) {
                    end=index;
                }

                if (index!=n*n&&count++==6){
                    if(end!= e) temp.offer(end);
                    return false;
                }
                index++;
            }
            c-=flag;
            flag=-flag;
        }

        return true;
    }
}