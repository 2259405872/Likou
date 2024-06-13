package Sequence;

public class Test0008 {
    public static void main(String[] args) {
        System.out.println(new Solution0008_1().myAtoi("words and 987"));
    }
}

class Solution0008_1 {
    public int myAtoi(String s) {
        int result=0;
        char[] chars = s.toCharArray();
        boolean isNegative = false;
        boolean isNumber = false;

        for (char c : chars) {
            if (!isNumber&&c == '-') {
                isNumber = true;
                isNegative = true;
            } else if (!isNumber && c == '+') {
                isNumber = true;
                isNegative=false;
            } else if ('0'<=c&&c <= '9'){
                int temp=result;
                isNumber = true;
                result*=10;
                result+=(c-48);
                if(result/10!=temp) return isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }else if (c==' '){
                if (isNumber){
                    break;
                }
            }else{
                break;
            }
        }

        return result*(isNegative? -1:1);
    }
}
