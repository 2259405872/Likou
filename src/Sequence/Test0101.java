package Sequence;

public class Test0101 {
}

class Solution0101_1 {
    public boolean isSymmetric(TreeNode root) {
        return isEqual(root.left,root.right);
    }

    public boolean isEqual(TreeNode left, TreeNode right) {
        if (left==null||right==null) return left==right;
        if(left.val!= right.val) return false;
        return isEqual(left.left, right.right)&&isEqual(left.right, right.left);
    }
}

class Solution0101_2 {
    public boolean isSymmetric(TreeNode root) {
        return traversal(root.left,root.right);
    }

    public boolean traversal(TreeNode l, TreeNode r){
        if (r==null||l==null) return r==l;

        if(l.val!=r.val) return false;

        return traversal(l.left,r.right)&&traversal(l.right,r.left);
    }
}