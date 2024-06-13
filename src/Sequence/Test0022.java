package Sequence;

import java.util.ArrayList;
import java.util.List;

public class Test0022 {
}

class Solution0022_1 {
    List<String> result;
    char[] chars;
    int n;
    public List<String> generateParenthesis(int n) {
        this.result=new ArrayList<String>();
        this.chars = new char[n * 2];
        this.n = n;

        dfs(0,n,0);

        return result;
    }

    private void dfs(int index,int leftCount,int rightCount) {
        if (leftCount>0){
            chars[index]='(';
            dfs(index+1,leftCount-1,rightCount+1);
        }

        if (rightCount>0){
            chars[index]=')';
            if (index==n*2-1){
                result.add(new String(chars));
            }else {
                dfs(index+1,leftCount,rightCount-1);
            }

        }
    }
}

class Solution0022_2 {
    List<String> ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        traverse(n,0,new char[n*2],0);
        return ans;
    }

    public void traverse(int l,int r,char[] records,int index){
        if (index== records.length) ans.add(new String(records));

        if (l>0){
            records[index]='(';
            traverse(l-1,r+1,records,index+1);
        }

        if (r>0){
            records[index]=')';
            traverse(l,r-1,records,index+1);
        }
    }
}