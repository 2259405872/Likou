package Sequence;

import java.util.LinkedList;
import java.util.Queue;

public class Test0173 {
}

class BSTIterator {
    Queue<Integer> q;
    public BSTIterator(TreeNode root) {
        q = new LinkedList<>();
        helper(q, root);
    }
    private void helper(Queue<Integer> q, TreeNode root){
        if (root == null){
            return;
        }
        helper(q, root.left);
        q.offer(root.val);
        helper(q, root.right);
    }

    /** @return the next smallest number */
    public int next() {
        if (!q.isEmpty()){
            return q.poll();
        }
        return -1;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !q.isEmpty();
    }
}
