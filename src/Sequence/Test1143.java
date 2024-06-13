package Sequence;

public class Test1143 {
}

class Solution1143_1 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int length1 = chars1.length,length2 = chars2.length;
        int[][] dp = new int[length1+1][length2+1];

        for (int i = 1; i <= length1; i++)
            for (int j = 1; j <= length2; j++)
                if (chars1[i-1] == chars2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);


        return dp[length1][length2];
    }
}
