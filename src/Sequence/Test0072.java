package Sequence;

import java.util.Arrays;

public class Test0072 {
    public static void main(String[] args) {
        System.out.println(new Solution0072_2().minDistance("sea","ate"));
    }
}

class Solution0072_1 {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        if (length1==0||length2==0) return length1==0 ? length2 : length1;

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        int[][] records = new int[length1][length2];
        records[0][0] =chars1[0]==chars2[0]?0:1;
        boolean b1 = true,b2=true;
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (i-1>=0&&j-1>=0){
                    records[i][j] = records[i-1][j-1]+(chars1[i]==chars2[j]?0:1);
                    records[i][j] = Math.min(records[i][j],records[i-1][j]+1);
                    records[i][j] = Math.min(records[i][j],records[i][j-1]+1);
                } else if (i - 1 >= 0) {
                    if (chars1[i]==chars2[j]&&b1) {
                        records[i][j] = records[i-1][j];
                        b1=false;
                    }else {
                        records[i][j] = records[i-1][j]+1;
                    }
                } else if (j - 1 >= 0) {
                    if (chars1[i]==chars2[j]&&b2) {
                        records[i][j] = records[i][j-1];
                        b2=false;
                    }else {
                        records[i][j] = records[i][j-1]+1;
                    }

                }
            }
        }


        return records[length1-1][length2-1];
    }
}

class Solution0072_2 {
    public int minDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;
        if (length1==0||length2==0) return length1==0 ? length2 : length1;

        int[][] dp = new int[length2][length1];
        for (int i = 0; i < length2; i++){
            char c1 = chars2[i];
            for (int j = 0; j < length1; j++){
                char c2 = chars1[j];
                int add = c1 == c2 ? 0 : 1;

                if (i>0&&j>0){
                    dp[i][j]=dp[i-1][j-1]+ add;
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+1);
                    dp[i][j] = Math.min(dp[i][j],dp[i][j-1]+ 1);
                }
                else if (i>0) dp[i][j]=dp[i-1][j]+1;
                else if (j>0) dp[i][j]=(c1 == c2)?Math.min(dp[i][j-1]+1,j):dp[i][j-1]+1;
                else dp[i][j]= add;
            }

        }
        return dp[length2-1][length1-1];

    }
}


