package Sequence;

public class Test0221 {
    public static void main(String[] args) {
        new Solution0221_1().maximalSquare( new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},
        });
    }
}

class Solution0221_1 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int result ='0';

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]=='1'){
                    char min='0';
                    if (i-1>=0&&j-1>=0) {
                        min=matrix[i-1][j-1];
                        min= (char) Math.min(matrix[i][j-1],min);
                        min= (char) Math.min(matrix[i-1][j],min);
                    }
                    min+=1;
                    matrix[i][j] = min;

                    result=Math.max(min,result);
                }
            }
        }
        return (result-'0')*(result-'0');
    }
}
