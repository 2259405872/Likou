package Sequence;

import java.util.ArrayList;
import java.util.List;

public class Test0077 {

}

class Solution0077_1 {
    List<List<Integer>> result;
    int k;
    int n;
    public List<List<Integer>> combine(int n, int k) {
        this.n=n;
        this.k=k;
        result=new ArrayList<List<Integer>>();
        traversal(0,1,new Integer[k]);
        return result;
    }

    public void traversal(int row,int column,Integer[] records){
        if (column>n){
            return;
        }else {
            records[row]=column;
            if (row==k-1){
                result.add(List.of(records));
            }else {
                traversal(row+1,column+1, records);
            }

            traversal(row, ++column, records);
        }

    }
}
