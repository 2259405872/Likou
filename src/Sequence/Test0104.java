package Sequence;

public class Test0104 {
}

class Solution0104_1 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}

class Solution0104_2 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}