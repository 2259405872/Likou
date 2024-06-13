package Sequence;

public class Test0543 {
}

class Solution0543_1 {
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return max;
    }

    public int traverse(TreeNode root){
        if (root==null) return 0;

        int l = traverse(root.left);
        int r = traverse(root.right);

        max=Math.max(l+r+1, max);

        return Math.max(l,r)+1;
    }
}