package Sequence;

public class Test0106 {
}

class Solution0106_1 {
    int in;
    int post;
    int[] inorder;
    int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        in=inorder.length-1;
        post=postorder.length-1;
        this.inorder=inorder;
        this.postorder=postorder;

        return build(Integer.MIN_VALUE);
    }

    public TreeNode build(int stop){
        if (post<0) return null;

        if (inorder[in]==stop){
            in--;
            return null;
        }

        TreeNode node = new TreeNode(postorder[post--]);
        node.right=build(node.val);
        node.left=build(stop);

        return node;
    }
}