package Sequence;

public class Test0201 {
}

class Solution0201_1 {
    public int rangeBitwiseAnd(int left, int right) {
        int i=0;
        while (left!=right){
            left>>=1;
            right>>=1;
            i++;
        }

        return left<<i;
    }
}
