package Sequence;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Test0144 {
}

class Solution0144_1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if(root==null) return list;

        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            list.add(node.val);

            if (node.right != null) deque.push(node.right);
            if (node.left != null) deque.push(node.left);
        }

        return list;
    }
}

class Solution0144_2 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return list;
    }

    private void traverse(TreeNode root) {
        if(root==null) return;
        list.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}