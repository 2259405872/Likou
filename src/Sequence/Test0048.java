package Sequence;

public class Test0048 {
}

class Solution0048 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;

        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < (len + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j]=matrix[len-1-j][i];
                matrix[len-1-j][i]=matrix[len-1-i][len-1-j];
                matrix[len-1-i][len-1-j]=matrix[j][len-1-i];
                matrix[j][len-1-i]=temp;
            }
        }
    }
}

class Solution0048_2 {
    public void rotate(int[][] matrix) {
        int len = matrix.length/2;

        for (int i = 0; i <len; i++) {
            for (int j = 0; j <=len; j++) {
                int temp = matrix[i][j];
                matrix[i][j]=matrix[len-j-1][i];
                matrix[len-j-1][i]=matrix[len-1-i][len-j-1];
                matrix[len-1-i][len-j-1]=matrix[j][len-1-i];
                matrix[j][len-1-i]=temp;
            }
        }

    }
}

class Solution0048_3 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;

        for (int i = 0; i < len/2; i++) {
            for (int j = 0; j < (len+1)/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j]=matrix[len-1-j][i];
                matrix[len-1-j][i]=matrix[len-1-i][len-1-j];
                matrix[len-1-i][len-1-j]=matrix[j][len-1-i];
                matrix[j][len-1-i]=temp;
            }
        }

    }
}