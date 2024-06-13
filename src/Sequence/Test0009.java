package Sequence;

public class Test0009 {

}

/*
    给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
        回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
        例如，121 是回文，而 123 不是。
*/

class Solution0009_00 {
    public boolean isPalindrome(int x) {
        int num=0;
        int temp=x;
        if(x<0){
            return false;
        }else {
            while(temp>0){
                num*=10;
                num+=temp%10;
                temp/=10;
            }
        }
        return num==x;
    }
}


class Solution0009_2 {
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        if (x<10) return true;

        int sum=0,temp=x;

        while (x>0){

            sum*=10;
            sum+=x % 10;
            x/=10;
        }

        return temp==sum;
    }
}
