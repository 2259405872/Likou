package Sequence;

public class Test1047 {
    public static void main(String[] args) {
        new Solution1047_1().removeDuplicates("abbaca");
    }
}

class Solution1047_1 {
    public String removeDuplicates(String s) {
        int length = s.length();
        if (length <= 1) return s;

        char[] chars = s.toCharArray();
        char[] record = new char[length];
        int size = 0;

        for (int i = 0; i < length; i++) {
            if (size==0||chars[i] != record[size - 1]){
                record[size++] = chars[i];
            }else {
                size--;
            }

        }

        return new String(record, 0, size);
    }
}