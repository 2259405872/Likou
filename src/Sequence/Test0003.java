package Sequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Test0003 {
    public static void main(String[] args) {
        new Solution0003_3().lengthOfLongestSubstring("aab");
    }

}


//    给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。


class Solution0003_00 {
    public int lengthOfLongestSubstring(String s) {
        int soulution = 0,len=s.length(),right=-1;
        HashSet<Character> set=new HashSet<Character>();
        for (int i = 0; i < len; i++) {
            if (i>0){
                set.remove(s.charAt(i-1));
            }

            while (right+1<len&&!set.contains(s.charAt(right+1))){
                set.add(s.charAt(++right));
            };
            soulution=Math.max(soulution,right-i+1);
        }

        return soulution;
    }
}



class Solution0003_01 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }
}

class Solution0003_second {
    public int lengthOfLongestSubstring(String s) {
        int result = 0,l=0,r=0;
        int len = s.length();
        if (len<2) return len;
        char[] chars = s.toCharArray();
        int[] set = new int[123];
        Arrays.fill(set,-1);
        //记录第一个字符的旧下标和新下标
        int temp = set[chars[r]];
        set[chars[r]]=r;
        while (r<len){
            //移动左边界，直到遇到相同的字符
            while (l>temp){//当旧下标出现在左边界或者左边界后边时说明遇到重复字符
                //移动右边界
                r++;
                //当达到末尾时退出
                if (r==len) break;
                //记下旧下标
                temp=set[chars[r]];
                //记录右边界字符新下标
                set[chars[r]]=r;
            }
            //判断当前字符串长度是否大于，目前的最长记录，并记录
            if (r-l>result) result=r-l;
            //移动左边界到旧的重复字符旧下标后一位
            l=temp+1;
        }
        return result;
    }
}

class Solution0003_3 {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length<=1) return length;

        char[] chars = s.toCharArray();
        int[] records = new int[127];
        Arrays.fill(records,-1);
        int ans=0,start=0;

        int record=0;
        for (int i = 0; i < length; i++) {
            char c = chars[i];
            record = records[c];
            records[c]=i;

            if (!(record<start||record>=i)){
                ans=Math.max(i-start,ans);
                start=record+1;
                i=record;
            }
        }
        ans=Math.max(length-start,ans);

        return ans;
    }
}