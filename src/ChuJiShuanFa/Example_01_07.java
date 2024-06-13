package ChuJiShuanFa;

public class Example_01_07 {
    public int[] plusOne(int[] digits) {
        int i = digits.length-1;
        int[] digits1;
        while (true) {
            if (++digits[i]>=10) {
                if (i==0) {
                    digits1=new int[digits.length+1];
                    digits1[0]=1;
                    return digits1;
                }
                digits[i]=0;
                i--;
            } else {
                digits1=digits; 
                break;      
            }
        }
        return digits1;
    }
}
