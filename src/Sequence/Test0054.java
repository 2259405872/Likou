package Sequence;

import java.util.ArrayList;
import java.util.List;

public class Test0054 {
    public static void main(String[] args) {
        new Solution0054_2().spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
    }
}

class Solution0054_1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int c=matrix.length;
        int r=matrix[0].length;
        int i=-1,j=0,flag=1;
        while (r>0&&c>0){
            for (int k = 0; k <r; k++) {
                i+=flag;
                result.add(matrix[j][i]);
            }
            c--;
            for (int k = 0; k < c; k++) {
                j+=flag;
                result.add(matrix[j][i]);
            }
            r--;
            flag=-flag;
        }
        return result;
    }
}

class Solution0054_2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int i=0,j=0;
        int t=0,b=matrix.length-1,l=0,r=matrix[0].length-1;

        ans.add(matrix[i][j]);
        do {
            while (j<r) ans.add(matrix[i][++j]);
            t++;

            if (i>=b) break;
            while (i<b) ans.add(matrix[++i][j]);
            r--;

            if (j<=l) break;
            while (j>l) ans.add(matrix[i][--j]);
            b--;

            if (i<=t) break;
            while (i>t) ans.add(matrix[--i][j]);
            l++;
        }while (j<r);

        return ans;
    }
}

class Solution0054_3 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        List<Integer> ans = new ArrayList<>();

        int i=0,j=0;
        int t=-1,b=row,l=-1,r=column;

        ans.add(matrix[i][j]);
        while (true){
            if (l>=r-1) break;
            while (j+1<r) ans.add(matrix[i][++j]);
            t++;

            if (t>=b-1) break;
            while (i+1<b) ans.add(matrix[++i][j]);
            r--;

            if (l>=r-1) break;
            while (j-1>l) ans.add(matrix[i][--j]);
            b--;

            if (t>=b-1) break;
            while (i-1>t) ans.add(matrix[--i][j]);
            l++;
        }

        return ans;
    }
}