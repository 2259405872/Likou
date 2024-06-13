package Sequence;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Test0145 {
}

class Solution0145_1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        TreeNode prev = null;
        while (root!=null||!deque.isEmpty()) {
            while (root!=null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();

            if (root.right==null||root.right==prev) {
                list.add(root.val);
                prev = root;
                root = null;
            }else {
                deque.push(root);
                root = root.right;
            }
        }
        return list;
    }
}

class Solution145_2 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        traverse(root);
        return list;
    }

    public void traverse(TreeNode root) {
        if (root==null) return;
        traverse(root.left);
        traverse(root.right);
        list.add(root.val);
    }
}
