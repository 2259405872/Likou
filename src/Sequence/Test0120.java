package Sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test0120 {
    public static void main(String[] args) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        lists.add(List.of(2));
        lists.add(List.of(3,4));
        lists.add(List.of(5,6,7));
        lists.add(List.of(4,1,8,3));
        new Solution0120_1().minimumTotal(lists);
    }
}

class Solution0120_1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] rows = new int[triangle.size()][];

        int index=0;
        int min=Integer.MAX_VALUE;
        for (List<Integer> list : triangle) {
            min=Integer.MAX_VALUE;
            int length = 1+index;
            int[] row = new int[length];

            int column=0;
            for (Integer integer : list) {
                if (column-1>=0&&column<index){
                    row[column]=Math.min(rows[index-1][column-1],rows[index-1][column])+integer;
                }else if (column-1>=0){
                    row[column]= rows[index-1][column-1]+integer;
                }else if(column<index){
                    row[column]= rows[index-1][column]+integer;
                }else {
                    row[column] = integer;
                }

                min=Math.min(min,row[column]);
                column++;
            }

            rows[index]=row;
            index++;
        }

        return min;
    }
}