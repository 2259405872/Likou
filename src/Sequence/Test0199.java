package Sequence;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test0199 {
}

class Solution0199_1 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {  //将当前层的最后一个节点放入结果列表
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}

class Solution0199_2 {
    List<Integer> ans=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        traverse(root,1);
        return ans;
    }

    public void traverse(TreeNode root,int level) {
        if (root==null) return;
        if (level>ans.size()) ans.add(root.val);

        traverse(root.right,level+1);
        traverse(root.left,level+1);
    }
}