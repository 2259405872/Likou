package Sequence;

public class Test0279 {
    public static void main(String[] args) {
        new Solution0279_1().numSquares(12);
    }
}


class Solution0279_1 {
    public int numSquares(int n) {
        int[] ints = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int count=Integer.MAX_VALUE;

            for (int j = 1; j*j <= i; j++)
                count=Math.min(count,ints[i-j*j]);

            ints[i] = count+1;
        }

        return ints[n];
    }
}