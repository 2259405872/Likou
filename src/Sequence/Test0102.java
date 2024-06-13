package Sequence;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test0102 {
}

class Solution0102_1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> list=new ArrayList<>();
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll != null){
                    list.add(poll.val);
                    if (poll.left!=null) queue.offer(poll.left);
                    if (poll.right!=null) queue.offer(poll.right);
                }
            }

            result.add(list);
        }

        return result;
    }
}

class Solution0102_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode now;
            ArrayList<Integer> list = new ArrayList<>();
            Queue<TreeNode> temp = new LinkedList<>();

            while ((now = queue.poll()) != null){
                if (now.left!=null) temp.offer(now.left);
                if (now.right!=null) temp.offer(now.right);
                list.add(now.val);
            }

            queue=temp;
            ans.add(list);
        }

        return ans;
    }
}