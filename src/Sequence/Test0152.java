package Sequence;

public class Test0152 {
    public static void main(String[] args) {
        new Solution0152_1().maxProduct(new int[]{2,3,-2,4});
    }
}

class Solution0152_1 {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int ans = Integer.MIN_VALUE,pre=1,pre1=1;

        for (int num : nums) {
            if (num<0){
                int temp = pre;
                pre = pre1;
                pre1 = temp;
            }

            pre = Math.max(pre*num,num);
            pre1 = Math.min(pre1*num, pre);

            ans = Math.max(ans, pre);
        }

        return ans;
    }
}
