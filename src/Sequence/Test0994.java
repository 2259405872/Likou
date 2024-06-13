package Sequence;

public class Test0994 {
}

class Solution0994_1 {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                if (grid[i][j]==2) traverse(i, j,grid,2);

        int ans=2;
        for (int[] ints : grid) {
            for (int j = 0; j < columns; j++) {
                int now = ints[j];
                if (now == 1) return -1;

                ans = Math.max(ans, now);
            }
        }

        return ans-2;
    }

    public void traverse(int row,int column,int[][] grid,int count){
        if (row<0||column<0||row>=grid.length||column>=grid[0].length) return;

        int now = grid[row][column];

        if (now>=count||now==1){
            grid[row][column] = count;

            traverse(row+1,column,grid,count+1);
            traverse(row-1,column,grid,count+1);
            traverse(row,column+1,grid,count+1);
            traverse(row,column-1,grid,count+1);
        }
    }
}
