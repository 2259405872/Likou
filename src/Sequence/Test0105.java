package Sequence;

public class Test0105 {
    public static void main(String[] args) {
        new Solution0105_2().buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }
}

class Solution0105_1 {
    int[] preorder;
    int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        TreeNode result=build(0, inorder.length,0);

        return result;
    }

    public TreeNode build(int lIndex,int rIndex,int preIn) {
        int root=preorder[preIn];
        TreeNode result=new TreeNode(root,null,null);

        int index=lIndex;
        for (;index<rIndex;index++){
            if (root==inorder[index]) break;
        }

        int lLen = index - lIndex;
        if(lLen !=0){
            result.left=build(lIndex,index,preIn+1);
        }
        if(rIndex-index!=1){
            result.right=build(index+1,rIndex,preIn+lLen+1);
        }
        return result;
    }
}

class Solution0105_2 {
    private int in = 0;
    private int pre = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }
    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (pre == preorder.length) return null; // pre走到preorder末尾
        if (inorder[in] == stop) { // in指针走到了停止点
            in++; // stop点废弃了，in推进一位
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = build(preorder, inorder, node.val);
        // 左子树的停止点是当前的根节点的值
        node.right = build(preorder, inorder, stop);
        // 右子树的停止点是当前树的停止点
        return node;
    }
}

class Solution0105_3 {
    int inIndex = 0;
    int preIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder,Integer.MAX_VALUE);
    }

    public TreeNode build(int[] preorder, int[] inorder,int stopVal){
        if (preIndex==preorder.length) return null;

        if (stopVal==inorder[inIndex]){
            inIndex++;
            return null;
        }

        TreeNode node = new TreeNode(preorder[preIndex++]);
        node.left=build(preorder, inorder, node.val);
        node.right=build(preorder, inorder, stopVal);

        return node;
    }
}