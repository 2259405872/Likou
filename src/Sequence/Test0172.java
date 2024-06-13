package Sequence;

public class Test0172 {
}

class Solution0172_1 {
    public int trailingZeroes(int n) {
        int ans=0;
        for (int i=5; i<=n; i+=5){
            for (int x = i; x % 5 == 0; x /= 5) {
                ++ans;
            }
        }

        return ans;
    }
}

class Solution0172_2 {
    class Solution {
        public int trailingZeroes(int n) {
            int k = 0;
            while (n > 4) {
                k += n / 5;
                n = n / 5;
            }
            return k;
        }
    }
}