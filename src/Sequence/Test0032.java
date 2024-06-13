package Sequence;

public class Test0032 {
    public static void main(String[] args) {
        new Solution0032_1().longestValidParentheses("(()");
    }
}

class Solution0032_1 {
    public int longestValidParentheses(String s) {
        int pre=0,ans=0,len=s.length();
        char[] chars = s.toCharArray();
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            char c = chars[i];

            if (c == '(') {
                pre++;
            }else if(pre>0) {
                pre--;
                dp[i]=dp[i-1]+2;

                while (i - dp[i] >= 0) {
                    int temp = dp[i - dp[i]];
                    if (!(temp >0)) break;
                    dp[i]+= temp;
                }

                ans=Math.max(ans,dp[i]);
            }


        }

        return ans;
    }
}
