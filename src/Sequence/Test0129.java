package Sequence;

public class Test0129 {
}

class Solution0129_1 {
    public int sumNumbers(TreeNode root) {
        if (root==null) return 0;
        int sum = root.val;
        if (root.left==null&&root.right==null) return sum;
        return sum(root.left,sum)+sum(root.right,sum);
    }

    public int sum(TreeNode root,int sum) {
        if (root==null) return 0;
        sum*=10;
        sum+=root.val;
        if (root.left==null&&root.right==null) return sum;
        return sum(root.left,sum)+sum(root.right,sum);
    }

}