package Sequence;

public class Test0076 {
    public static void main(String[] args) {
        new Solution_0076_1().minWindow("a","aa");
    }
}

class Solution_0076_1 {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        char[] chars = s.toCharArray();
        for (char c : t.toCharArray()) {
            map[c] +=1;
        }

        int count=t.length(),start=0,minStart=-1,minEnd=0,minLen=s.length()+1;
        for (int i = 0; i < s.length(); i++) {
            char c = chars[i];
            if (map[c]>0){
                count--;
            }
            map[c]--;

            while (count==0){
                if (i-start+1<minLen){
                    minLen=i-start+1;
                    minStart=start;
                }
                char remove = chars[start];
                map[remove]++;
                if (map[remove]>0){
                    count++;
                }

                start++;
            }
        }

        return minStart==-1?"":s.substring(minStart,minStart+minLen);
    }
}

class Solution0076_1 {
    public String minWindow(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        int[] map = new int[128];

        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        for (char c : chars2) map[c]++;

        int count = length2,start=0,minStart = -1,minEnd = length1;
        for (int i = 0; i < length1; i++) {
            char c = chars1[i];
            if (map[c]-->0) count--;

            while (count==0){
                if (i-start+1<minEnd-minStart){
                    minStart=start;
                    minEnd=i+1;
                }
                if (++map[chars1[start++]]>0) count++;
            }
        }

        return minStart<0?"":s.substring(minStart,minEnd);
    }
}