package Sequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test0030 {
    public static void main(String[] args) {
        new Solution0030_1().findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","good"});
    }

}

class Solution0030_1 {
    public List<Integer> findSubstring(String s, String[] words) {
        int len = s.length(),wordCount = words.length,wordLen=words[0].length();
        Map<String, Integer> wordMap = new HashMap<>();
        //1.统计各单词数量
        for (String word : words) {
            wordMap.put(word,wordMap.getOrDefault(word,0)+1);
        }
        List<Integer> result = new ArrayList<>();

        //2.因为以wordLen为步长，所以wordLen代表了存在的遍历字符串的方式，因为超过单词长度就是重复遍历了只是遍历的长度比上次短而已
        for (int i = 0; i < wordLen; i++) {
            int l=i,r=i,count=0;
            Map<String, Integer> tempMap = new HashMap<>();
            //3.以wordLen为步长开始遍历
            while (r+wordLen<=len){
                String word = s.substring(r, r + wordLen);
                //移动右边界
                r+=wordLen;
                //3.1words是否存在该单词
                if (wordMap.containsKey(word)){
                    //3.1.1存在该单词，继续
                    //1.更新计数
                    count++;
                    tempMap.put(word,tempMap.getOrDefault(word,0)+1);
                    //2.计数如果超额左边界要移动到超额单词处
                    while (tempMap.getOrDefault(word,0)>wordMap.getOrDefault(word,0)){
                        //2.1移动左边界
                        String left = s.substring(l, l+wordLen);
                        l+=wordLen;
                        //2.2更新计数
                        tempMap.put(left,tempMap.getOrDefault(left,1)-1);
                        count--;
                    }
                }else {
                    //3.1.2不存在该单词,说明断了，全部重新开始
                    count=0;
                    l=r;
                    tempMap.clear();
                }
                //3.2当子串单词数量满足wordsCount左边界计入结果
                if (count==wordCount) result.add(l);
            }
        }
        return result;
    }
}
