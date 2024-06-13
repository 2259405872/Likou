package Sequence;

public class Test0066 {
}

class Solution0066 {
    public int[] plusOne(int[] digits) {
        int temp=1;
        for (int i = digits.length-1; i >-1 ; i--) {
            int sum = digits[i] + temp ;
            digits[i]= sum %10;
            temp= sum /10;
        }

        if (temp==1){
            digits = new int[digits.length + 1];
            digits[0]=1;
        }

        return digits;
    }
}