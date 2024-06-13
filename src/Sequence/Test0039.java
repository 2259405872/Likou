package Sequence;

import java.util.*;

public class Test0039 {
    public static void main(String[] args) {
        new Solution0039_1().combinationSum(new int[]{2,3,6,7},7);
    }
}

class Solution0039_1 {
    List<List<Integer>> result;
    int[] candidates;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        if (candidates.length==0) return result;

        Arrays.sort(candidates);
        ArrayList<Integer> record = new ArrayList<>();
        this.candidates=candidates;

        traversalCandidates(0,record, target);

        return result;
    }

    public void traversalCandidates(int i,ArrayList<Integer> record,int target){
        for (;i<candidates.length;i++) {
            int candidate= candidates[i];
            if (candidate>target) {
                return;
            }else{
                record.add(candidate);
                if(candidate==target) {
                    result.add(new ArrayList<>(record));
                }else {
                    traversalCandidates(i,record,target-candidate);
                }
                record.remove(record.size()-1);
            }
        }
    }
}

class Solution0039_2 {
    List<List<Integer>> ans=new ArrayList<>();
    int[] candidates;
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates=candidates;
        this.target=target;

        Arrays.sort(candidates);
        for (int i=candidates.length-1;i>=0;i--) traverse(new ArrayList<Integer>(),0,i);

        return ans;
    }

    public void traverse(ArrayList<Integer> record,int sum,int index){
        sum+=candidates[index];
        if (sum>target) return;
        record.add(candidates[index]);

        if (sum==target) ans.add(new ArrayList<>(record));
        else for (int i = index; i >=0; i--)
            traverse(record,sum,i);

        record.remove(record.size()-1);
    }
}
