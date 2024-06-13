package Sequence;

public class Test0108 {
}
class Solution0108_1 {
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return build(0, nums.length);
    }

    public TreeNode build(int start, int end){
        int mid = (start + end) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        if (mid==start) return treeNode;


        treeNode.left=build(start,mid);

        if (mid+1==end) return treeNode;
        treeNode.right=build(mid+1,end);

        return treeNode;
    }
}

class Solution108_2 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        if (length==0) return null;
        return build(0,length-1,nums);
    }

    public TreeNode build(int s, int e,int[] nums) {
        int m = (s + e) / 2;
        TreeNode ans = new TreeNode(nums[m]);
        if (s>=e) return ans;

        ans.right=build(m+1,e,nums);
        if (m==s) return ans;
        ans.left=build(s,m-1,nums);

        return ans;
    }
}