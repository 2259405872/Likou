package Sequence;

public class Test0097 {
    public static void main(String[] args) {
        new Solution0097_1().isInterleave("aabcc","dbbca","aadbbcbcac");
    }
}

class Solution0097_1 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int o = s3.length();
        if (m+n!=o) return false;

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] chars3 = s3.toCharArray();


        boolean[][] booleans = new boolean[m + 1][n + 1];
        booleans[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (booleans[i][j]){
                    char c=0;
                    if(i+j<m+n) c = chars3[i + j];

                    if (i+1<=m) booleans[i+1][j]=chars1[i]==c;
                    if (j+1<=n) booleans[i][j+1]=chars2[j]==c;
                }
            }
        }

        return booleans[m][n];
    }
}