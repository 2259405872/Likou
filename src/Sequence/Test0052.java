package Sequence;

public class Test0052 {
    public static void main(String[] args) {
        int i = new Solution0052_1().totalNQueens(4);
    }
}

class Solution0052_1 {

    public int totalNQueens(int n) {
        if (n <=1) return n;
        int result=0;
        int[] board=new int[n];

        int rowIndex=0,columnIndex=0;
        while (true){
            boolean rightful = isRightful(rowIndex, columnIndex, board);
            if (rightful){
                board[rowIndex]=columnIndex;
                if (rowIndex==n-1){
                    result++;
                    rowIndex--;
                    columnIndex=board[rowIndex]+1;
                }else {
                    rowIndex++;
                    columnIndex=0;
                }
            }else {
                if (columnIndex<n){
                    columnIndex++;
                }else {
                    rowIndex--;
                    if (rowIndex>=0){
                        columnIndex=board[rowIndex]+1;
                    }else {
                        break;
                    }
                }
            }
        }


        return result;
    }

    private boolean isRightful(int rowIndex,int columnIndex,int[] board){
        if (columnIndex>=board.length) return false;
        for (int i = 0; i < rowIndex; i++) {
            int index = board[i];
            if (index==columnIndex||(rowIndex-i==Math.abs(columnIndex-index))){
                return false;
            }
        }
        return true;
    }
}