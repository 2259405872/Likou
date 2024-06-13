package Sequence;

public class Test0114 {
}

class Solution0114_1 {
    TreeNode current;
    public void flatten(TreeNode root) {
        current=root;
        TreeNode l=root.left;
        TreeNode r = root.right;
        current.left=null;

        if(l!=null){
            current.right=l;
            flatten(l);
        }

        if(r!=null){
            current.right=r;
            flatten(r);
        }
    }

}

class Solution0114_2 {
    TreeNode now;
    public void flatten(TreeNode root) {
        if (root==null) return;
        now=root;

        TreeNode oldLeft = root.left;
        TreeNode oldRight = root.right;

        root.left=null;

        flatten(oldLeft);
        if (oldLeft!=null) {
            root.right=oldLeft;
            now.right=oldRight;
        }
        flatten(oldRight);
    }
}