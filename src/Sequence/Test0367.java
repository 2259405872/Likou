package Sequence;

public class Test0367 {
}

class Solution0367_1 {
    public boolean isPerfectSquare(int num) {
        if (num<0) return false;
        if (num<=1) return true;

        int start = 1, end = num-1;

        while (start <= end) {
            int mid = (start + end) >> 1;
            double v = (double) num / mid;

            if (v ==mid) return true;
            else if (v>mid) start = mid + 1;
            else end = mid - 1;
        }

        return false;
    }
}