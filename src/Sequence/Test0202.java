package Sequence;

import java.util.HashSet;

public class Test0202 {
}

class Solution0202_1 {
    public boolean isHappy(int n) {
        int slow=n, fast=sum(n);
        while (slow!=fast){
            slow=sum(slow);
            fast=sum(sum(fast));
        }

        return slow==1;
    }

    public static int sum(int n) {
        int sum = 0;

        while (n!=0) {
            int y = n % 10;
            sum +=y*y;
            n/=10;
        }

        return sum;
    }
}

class Solution0202_2 {
    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(n);

        while (n!=1) {
            n = sum(n);

            if (!hashSet.add(n)) return false;
        }

        return true;
    }

    public int sum(int n) {
        int sum = 0;
        while (n!=0) {
            int y = n % 10;
            sum +=y*y;
            n/=10;
        }
        return sum;
    }
}