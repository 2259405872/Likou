package Sequence;

import java.util.*;

public class Test0017 {
    public static void main(String[] args) {
        new Solution0017_2().letterCombinations("23");
    }
}

class Solution0017_1 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        int length = digits.length();
        if(length==0) return result;

        String[] phoneMap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        char[] chars = new char[length];
        int[] index = new int[length];
        char[] charArray = digits.toCharArray();

        int row=0;
        while (row>=0) {
            char digit = charArray[row];
            char[] dictionary = phoneMap[digit-'0'].toCharArray();

            //当前行是否遍历到末尾
            if (index[row] <dictionary.length) {
                //没到末尾，添加当前字符到字符串构建数组
                chars[row] = dictionary[index[row]++];

                //到没到最后一排
                if(row<length-1){
                    //没到,就继续向下走
                    row++;
                }else {
                    //到了,就添加字符串到结果集
                    result.add(new String(chars));
                }


            }else {
                //当前行已经到末尾，回溯
                index[row]=0;
                row--;
            }
        }
        return result;
    }
}

class Solution0017_2 {
    String[] phoneMap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> ans= new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        int length = digits.length();
        if (length ==0) return ans;
        traverse(new char[length], digits.toCharArray(),0);

        return ans;
    }

    public void traverse(char[] record,char[] cigits,int index){
        if (index==cigits.length){
            ans.add(new String(record));
            return;
        }

        for (char c : phoneMap[cigits[index]-'0'].toCharArray()) {
            record[index]=c;
            traverse(record,cigits,index+1);
        }
    }
}