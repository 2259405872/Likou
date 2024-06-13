package Sequence;

public class Test0189 {
}

class Solution0189_1 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
}

class Solution0189_2 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k%=n;
        if (k == 0) return;

        reverse(nums, 0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }

    public void reverse(int[] nums,int start, int end) {
        for (;start<end;start++,end--){
            int temp = nums[start];
            nums[start]=nums[end];
            nums[end] = temp;
        }
    }
}