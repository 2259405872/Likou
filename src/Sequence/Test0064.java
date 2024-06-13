package Sequence;

public class Test0064 {
}

class Solution0064_1 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j]+=minPre(i,j,grid);
            }
        }

        return grid[n-1][m-1];
    }

    public int minPre(int i, int j,int[][] grid) {
        if (i-1<0&&j-1<0) return 0;

        int top=Integer.MAX_VALUE;
        int left=Integer.MAX_VALUE;

        if (i-1>=0) top=grid[i-1][j];
        if (j-1>=0) left=grid[i][j-1];

        return Math.min(top,left);
    }
}

class Solution0064_2 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0&&j==0) continue;

                long up=i>0?grid[i-1][j]:Integer.MAX_VALUE;
                long left=j>0?grid[i][j-1]:Integer.MAX_VALUE;

                grid[i][j]+= (int) Math.min(up,left);
            }
        }

        return grid[m-1][n-1];
    }
}