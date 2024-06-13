package Sequence;

public class Test0226 {
}

class Solution0226_1 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = invertTree(root.left);

        root.left= invertTree(root.right);
        root.right=left;
        return root;
    }
}

class Solution226_2 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp= invertTree(root.left);

        root.left= invertTree(root.right);
        root.right= temp;

        return root;
    }
}