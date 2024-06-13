package Sequence;

public class Test0191 {
}

class Solution0191_1 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result=0;
        while (n!=0){
            result+=n&1;
            n>>>=1;
        }
        return result;
    }
}