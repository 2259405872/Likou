package Sequence;

public class Test0098 {
}

class Solution0098_1 {
    Integer pre=null;
    Integer mark=null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        if (pre!=null&& root.val>=pre) return false;
        return sss(root);
    }

    private boolean sss(TreeNode root) {
        pre = root.val;

        if (!isValidBST(root.left)) return false;
        if (mark!=null&&root.val<=mark) return false;
        mark = root.val;
        pre = root.val;

        return dfsR(root.right);
    }

    public boolean dfsR(TreeNode root){
        if (root == null) return true;

        if (pre!=null&&root.val<=pre) return false;
        return sss(root);
    }
}

class Solution0098_2 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidLeft(root.left,root,null)&&
                isValidRight(root.right,root,null);
    }

    public boolean isValidRight(TreeNode now,TreeNode pre,TreeNode temp ) {
        if (now==null) return true;
        return
                now.val> pre.val&&
                (temp==null||now.val< temp.val)&&
                isValidLeft(now.left,now,pre)&&
                isValidRight(now.right,now,temp);
    }

    public boolean isValidLeft(TreeNode now,TreeNode pre,TreeNode temp ) {
        if (now==null) return true;
        return
                now.val< pre.val&&
                (temp==null||now.val> temp.val)&&
                isValidLeft(now.left,now,temp)&&
                isValidRight(now.right,now,pre);
    }
}