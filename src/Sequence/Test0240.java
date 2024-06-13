package Sequence;

public class Test0240 {
    public static void main(String[] args) {
        new Solution0240_1().searchMatrix(new int[][]{
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25 },
        },2);
    }
}

class Solution0240_1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;

        return search(0,row,0,column,matrix,target);
    }

    public boolean search(int rs ,int re,int cs,int ce,int[][] matrix,int target){
        if (matrix[re-1][ce-1]<target||matrix[rs][cs]>target) return false;

        int rowIndex=rs, columnIndex=cs;
        if (matrix[rowIndex][columnIndex]==target) return true;
        while (rowIndex+1<re && columnIndex+1<ce) {
            if (matrix[++rowIndex][++columnIndex]>target)break;
            else if (matrix[rowIndex][columnIndex] == target) return true;
        }

        if (matrix[rowIndex][columnIndex]>target){
            return search(rowIndex,re,cs,columnIndex,matrix,target)
                    ||search(rs,rowIndex,columnIndex,ce,matrix,target);
        }else {
            if (rowIndex!=re-1) return search(rowIndex+1,re,cs,ce,matrix,target);
            if (columnIndex!=ce-1) return search(rs,re,columnIndex+1,ce,matrix,target);
        }

        return false;
    }
}
