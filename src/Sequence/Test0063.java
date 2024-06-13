package Sequence;

public class Test0063 {
}

class Solution0063_1 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m-1][n-1]==1||obstacleGrid[0][0]==1) return 0;

        obstacleGrid[0][0]=-1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int now = obstacleGrid[i][j];
                if (now <1) {
                    if (i+1<m&&obstacleGrid[i+1][j]<=0) {
                        obstacleGrid[i+1][j]+= now;
                    }

                    if (j+1<n&&obstacleGrid[i][j+1]<=0) {
                        obstacleGrid[i][j+1]+= now;
                    }
                }
            }
        }

        return -obstacleGrid[m-1][n-1];
    }

}