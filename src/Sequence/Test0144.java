package Sequence;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Test0144 {
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            list.add(node.val);

            if (node.left != null) deque.push(node.right);
            if (node.right != null) deque.push(node.left);
        }

        return list;
    }
}
