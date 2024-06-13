package Sequence;

public class Test0387 {
}

class Solution0387_1 {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] records = new int[26];

        int length = chars.length;
        for (int i = 0; i < length; i++) {
            char c = chars[i];

            int hash = c - 'a';

            if (records[hash]==0)
                records[hash]=i+1;
            else
                records[hash]=-1;

        }

        long result=Long.MAX_VALUE;

        for (int record : records) {
            if (record>0) result=Math.min(result,record);
        }

        return result==Long.MAX_VALUE?-1:(int)result-1;
    }
}
