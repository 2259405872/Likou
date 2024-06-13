package Sequence;

public class Test0190 {
    public static void main(String[] args) {
        new Solution0190().reverseBits(1);
    }
}

class Solution0190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result=0,count=32;

        while (n!=0){
            result<<= 1;
            int i = n % 2;
            result+=i;
            n>>>=1;
            count--;
        }
        return result<<count;
    }
}
