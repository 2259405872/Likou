package Sequence;

import java.util.ArrayList;
import java.util.List;

public class Test0051 {
    public static void main(String[] args) {
        new Solution0051_01().solveNQueens(4);
    }
}

class Solution0051_01 {
    List<List<String>> ans=new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        int[] record = new int[n];
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] ='.';

        backtrack(0,board,record,n,new String[n]);
        return ans;
    }

    public void backtrack(int rowIndex, char[][] board, int[] record,int n,String[] list) {
        if (rowIndex==n){
            ans.add(List.of(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isRightful(rowIndex, i, record)){
                board[rowIndex][i]='Q';
                record[rowIndex]=i;
                list[rowIndex]=String.valueOf(board[rowIndex]);

                backtrack(rowIndex+1,board,record,n,list);

                board[rowIndex][i]='.';
            }
        }
    }

    public boolean isRightful(int rowIndex,int columnIndex,int[] record) {
        for (int i = 0; i < rowIndex; i++)
            if (record[i]==columnIndex||rowIndex-i==Math.abs(record[i]-columnIndex))
                return false;

        return true;
    }
}