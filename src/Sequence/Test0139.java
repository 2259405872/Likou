package Sequence;

import java.util.HashSet;
import java.util.List;

public class Test0139 {
}

class Solution0139_1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        HashSet<String> strings = new HashSet<>(wordDict);

        boolean[] dp = new boolean[length+1];
        dp[0] = true;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && strings.contains(s.substring(j, i+1))) {
                    dp[i+1] = true;
                    break;
                }
            }
        }

        return dp[length];
    }
}

class Solution0139_2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] recodes = new boolean[length+1];
        recodes[0] = true;

        for (int i = 1; i <= length; i++) {
            for (int j = 0; j <= i; j++) {
                if (recodes[j]&& wordDict.contains(s.substring(j, i))) {
                    recodes[i] = true;
                    break;
                }
            }
        }

        return recodes[length];
    }
}
