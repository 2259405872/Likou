package Sequence;

import java.util.ArrayList;
import java.util.List;

public class Test0437 {
    public static void main(String[] args) {
        new Solution0437_1().pathSum(new TreeNode(1000000000,
                new TreeNode(1000000000,
                        new TreeNode(294967296,
                                new TreeNode(1000000000,
                                        new TreeNode(1000000000,new TreeNode(1000000000),null),null),null),null),null),0);
    }
}

class Solution0437_1 {

    int count=0;
    public int pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        traverse(root,targetSum,0L,list);
        return count;
    }

    public void traverse(TreeNode root,int target,long sum,List<Integer> list){
        if (root == null) return;

        sum+= root.val;
        hasTarget(list,sum,target);

        list.add(root.val);
        traverse(root.left,target,sum,list);
        traverse(root.right,target,sum,list);

        list.remove(list.size()-1);
    }

    public void hasTarget(List<Integer> list,long sum,int target){
        if (sum==target) count++;
        for (int val : list) {
            sum-=val;
            if (sum==target) count++;
        }
    }

}
