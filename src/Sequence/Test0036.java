package Sequence;

public class Test0036 {
}

class Solution0036_1 {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows=new int[9][9];
        int[][] columns=new int[9][9];
        int[][][] boxes=new int[3][3][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c !='.'){
                    int index = c - '0'-1;
                    int row = rows[i][index]++;
                    int column=columns[j][index]++;
                    int box = boxes[i/3][j/3][index]++;

                    if(row>0||column>0||box>0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
