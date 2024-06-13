package Sequence;

public class Test0230 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));
        new Solution0230_1().kthSmallest(treeNode,3);
    }
}

class Solution0230_1 {
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        int result=-1;
        if (root == null) return result;
        result=kthSmallest(root.left, k);
        if (result >0) return result;
        count++;
        if (count==k) return root.val;
        result=kthSmallest(root.left, k);
        return result;
    }
}

class Solution0230_2 {
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        int temp = -1;
        if (root == null) return temp;

        temp= kthSmallest(root.left, k);
        if (++count==k) temp=root.val;
        if (temp>=0) return temp;

        temp= kthSmallest(root.right, k);
        return temp;
    }
}