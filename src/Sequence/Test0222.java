package Sequence;

public class Test0222 {
}

class Solution0222_1 {
    public int countNodes(TreeNode root) {
        if (root==null) return 0;

        int lLevel = getLevel(root.left);
        int rLevel = getLevel(root.right);

        if (lLevel==rLevel){
            return countNodes(root.left)+1<<rLevel;
        }else{
            return countNodes(root.right)+1<<lLevel;
        }
    }

    public int getLevel(TreeNode root) {
        int level =0;
        while (root!=null) {
            level++;
            root=root.left;
        }

        return level;
    }
}