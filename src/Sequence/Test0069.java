package Sequence;

public class Test0069 {
    public static void main(String[] args) {
        new Solution0069_1().mySqrt(4);
    }
}

class Solution0069_1 {
    public int mySqrt(int x) {
        // 特殊值判断
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        int l=1,r=x;

        while (l<=r) {
            int mid = (l + r) / 2;
            int sqr = x/mid;
            if (sqr <mid){
                r=mid-1;
            } else if (sqr >mid) {
                l=mid+1;
            }else {
                return mid;
            }
        }

        return r;
    }
}

class Solution0069_2 {
    public int mySqrt(int x) {
        if (x <= 1) return x;

        int l=1,r=x-1;

        while (l<=r) {
            int mid = (l+r)>>1;

            if (x / mid == mid) return mid;
            else if (x / mid < mid) r = mid-1;
            else l = mid+1;
        }

        return r;
    }
}