package Sequence;

public class Test0125 {
    public static void main(String[] args) {
        new Solution0125_1().isPalindrome("A man, a plan, a canal: Panama");
    }
}

class Solution0125_1 {
    public boolean isPalindrome(String s) {
        boolean result = true;
        int l=0,r=s.length()-1;
        while (l<r) {
            if ((!Character.isAlphabetic(s.charAt(l))&&!Character.isDigit(s.charAt(l)))||(!Character.isAlphabetic(s.charAt(r))&&!Character.isDigit(s.charAt(r)))) {
                if (!Character.isAlphabetic(s.charAt(l))&&!Character.isDigit(s.charAt(l))) l++;
                if (!Character.isAlphabetic(s.charAt(r))&&!Character.isDigit(s.charAt(r))) r--;
            }else {
                if (Character.toLowerCase(s.charAt(l))!=Character.toLowerCase(s.charAt(r))) return false;
                l++;
                r--;
            }

        }
        return result;
    }
}