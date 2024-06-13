package Sequence;

public class Test0100 {
}

class Solution0100_1 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null||q==null){
            return q == p;
        }

        if (p.val == q.val){
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }else {
            return false;
        }
    }
}
