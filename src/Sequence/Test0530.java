package Sequence;

public class Test0530 {
}

class Solution0530_1 {
    int min;
    int pre;
    public int getMinimumDifference(TreeNode root) {
        min=Integer.MAX_VALUE;
        pre=-1;
        caculate(root);
        return min;
    }
    public void caculate(TreeNode root){
        if(root==null)return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        caculate(right);

        if (pre==-1){
            pre= root.val;
        }else {
            min=Math.min(min,pre-root.val);
            pre=root.val;
        }
        caculate(left);
    }
}