package Sequence;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Test0637 {
}

class Solution0637_1 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<Double>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        while(!deque.isEmpty()){
            int size=deque.size();
            int count=0;
            double sum=0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll!=null){
                    count++;
                    sum+=poll.val;

                    TreeNode left = poll.left;
                    TreeNode right = poll.right;

                    if (left!=null) deque.offer(left);
                    if (right!=null) deque.offer(right);
                }
            }
            result.add(sum/count);
        }

        return result;
    }
}