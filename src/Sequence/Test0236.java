package Sequence;

public class Test0236 {
}

class Solution0236_1 {
    TreeNode node;
    int p;
    int q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p= p.val;
        this.q= q.val;

        isHave(root);

        return node;
    }

    public boolean isHave(TreeNode root){
        if(root==null) return false;

        boolean cHave= p == root.val || q == root.val;

        boolean lHave = isHave(root.left);
        boolean rHave = isHave(root.right);

        if((lHave&&rHave)||(cHave&&(lHave||rHave))){
            node = root;
        }

        return lHave||rHave||cHave;
    }
}

class Solution0236_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}

class Solution0236_3 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return null;
        if (root == p ||root==q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        return left!=null ? left : right;
    }
}

