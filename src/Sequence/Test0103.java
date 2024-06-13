package Sequence;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Test0103 {
}

class Solution103_1 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> deque = new LinkedList<>();
        boolean flag= true;
        deque.offer(root);

        while (!deque.isEmpty()) {
            LinkedList<TreeNode> temp = new LinkedList<>();
            ArrayList<Integer> list = new ArrayList<>();

            if (flag){
                for (TreeNode node : deque) {
                    list.add(node.val);

                    if (node.left!=null) temp.push(node.left);
                    if (node.right!=null) temp.push(node.right);
                }
            }else {
                for (TreeNode node : deque) {
                    list.add(node.val);

                    if (node.right!=null) temp.push(node.right);
                    if (node.left!=null) temp.push(node.left);
                }
            }

            deque=temp;
            result.add(list);
            flag=!flag;
        }

        return result;
    }
}