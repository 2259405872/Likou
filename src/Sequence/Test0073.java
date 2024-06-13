package Sequence;

import java.util.Arrays;

public class Test0073 {
}

class Solution0073_1 {
    public void setZeroes(int[][] matrix) {
        int len1 = matrix.length;
        int len2 = matrix[0].length;
        int[] r=new int[len1];
        int[] c=new int[len2];
        Arrays.fill(r,1);
        Arrays.fill(c,1);

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (matrix[i][j]==0){
                    r[i]=0;
                    c[j]=0;
                }
            }
        }
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2;j++){
                matrix[i][j]*=c[j];
                matrix[i][j]*=r[i];
            }
        }
    }
}

class Solution0073_2 {
    public void setZeroes(int[][] matrix) {
        int len1 = matrix.length;
        int len2 = matrix[0].length;

        boolean[] row = new boolean[len1];
        boolean[] column = new boolean[len2];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (matrix[i][j]==0) {
                    row[i]=true;
                    column[j]=true;
                }
            }
        }

        for (int i = 0; i < len1; i++)
            for (int j = 0; j < len2; j++)
                if (column[j]||row[i]) matrix[i][j]=0;
    }
}

class Solution0073_3 {
    public void setZeroes(int[][] matrix) {
        int length1 = matrix.length;
        int length2 = matrix[0].length;

        boolean[] row = new boolean[length1];
        boolean[] column = new boolean[length2];

        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (matrix[i][j]==0) {
                    row[i]=true;
                    column[j]=true;
                }
            }
        }

        for (int i = 0; i < length1; i++)
            for (int j = 0; j < length2; j++)
               if (row[i]||column[j]) matrix[i][j]=0;

    }
}