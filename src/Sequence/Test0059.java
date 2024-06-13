package Sequence;

public class Test0059 {
    public static void main(String[] args) {
        new Solution0059_1().generateMatrix(3);
    }
}

class Solution0059_1 {
    public int[][] generateMatrix(int n) {
        int limit = n * n;
        int[][] matrix = new int[n][n];

        int i = 0, j = 0,count = 1;
        int up = -1, down = n, left = -1, right = n;

        while (count <= limit) {
            for (; count <= limit&&j < right; j++) matrix[i][j] = count++;
            if (++up>=down) break;
            j--;
            i++;

            for (; count <= limit&&i < down; i++) matrix[i][j] = count++;
            if (--right<=left) break;
            i--;
            j--;

            for (;count<=limit&&j>left;j--) matrix[i][j] = count++;
            if (--down<=up) break;
            j++;
            i--;

            for (;count<=limit&&i>up; i--) matrix[i][j] = count++;
            if (++left>=right) break;
            i++;
            j++;
        }

        return matrix;
    }
}
