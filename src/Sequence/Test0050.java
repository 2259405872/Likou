package Sequence;

public class Test0050 {
    public static void main(String[] args) {
        new Solution0050_1().myPow(2,-2147483648);
    }
}

class Solution0050_1 {
    public double myPow(double x, int n) {
        long m= n;
        m/=m>=0?1:-1;
        double result =1;

        while (m!=0){
            if ((m & 1)==1) result*=x;
            m>>=1;
            x*=x;
        }
        return n>=0? result:1/result;
    }
}
