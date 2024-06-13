package Sequence;

import java.util.Arrays;

public class Test0124 {
    public static void main(String[] args) {
        new Solution0124_2().maxPathSum(new TreeNode(1,new TreeNode(2),new TreeNode(3)));
    }
}

class Solution0124_1 {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = node.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, priceNewpath);

        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }
}

class Solution0124_2 {

    long ans= Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        traverse(root);
        return (int) ans;
    }

    public long traverse(TreeNode root){
        if (root==null) return Integer.MIN_VALUE;

        long val = root.val;
        long left = traverse(root.left);
        long right = traverse(root.right);

        long max=val;
        if (left<0&&right<0) max=val;
        else if (left < 0) max=val+right;
        else if (right < 0) max=val+left;
        else {
            ans=Math.max(val+left+right,ans);
            max=val+Math.max(left,right);
        }

        ans=Math.max(max,ans);
        return max;
    }
}