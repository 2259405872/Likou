package Sequence;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Test0094 {
}

class Solution0094_1 {
    List<Integer> ans;
    public List<Integer> inorderTraversal(TreeNode root) {
        this.ans = new ArrayList<>();
        traversal(root);
        return this.ans;
    }

    public void traversal(TreeNode root){
        if(root==null) return;
        traversal(root.left);
        ans.add(root.val);
        traversal(root.right);
    }

}


class Solution0094_2 {
    List<Integer> result;
    public List<Integer> inorderTraversal(TreeNode root) {
        this.result=new ArrayList<>();
        traversal(root);

        return result;
    }

    public void traversal(TreeNode root){
        if (root==null) return;
        traversal(root.left);
        result.add(root.val);
        traversal(root.right);
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();

        TreeNode pre=null;

        while(root!=null||!deque.isEmpty()){
            while(root!=null){
                deque.push(root);
                root=root.left;
            }
            root=deque.poll();

            if (root != null) ans.add(root.val);
            if (root != null) root = root.right;
        }

        return ans;
    }
}