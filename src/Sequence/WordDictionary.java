package Sequence;

public class WordDictionary {

    boolean isEnd;
    WordDictionary[] words;

    public WordDictionary() {
        isEnd = false;
        words = new WordDictionary[26];
    }

    public void addWord(String word) {
        char[] chars = word.toCharArray();
        WordDictionary temp=this;

        for (char c : chars) {
            WordDictionary[] words1 = temp.words;
            int index = c - 'a';
            WordDictionary w = words1[index];

            if (w==null) w= words1[index]=new WordDictionary();

            temp=w;
        }
        temp.isEnd=true;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        return searchIndex(chars,0);
    }

    private boolean searchIndex(char[] chars,int index) {
        if (index==chars.length) return isEnd;

        char c = chars[index];
        if (c=='.') {
            index++;
            for (WordDictionary dictionary : words) {
                if (dictionary!=null){
                    if (dictionary.searchIndex(chars,index)) return true;
                }
            }
        }else {
            int flag = c - 'a';
            WordDictionary dictionary = words[flag];
            if (dictionary !=null) return dictionary.searchIndex(chars,++index);
        }

        return false;
    }
}

class TestWordDictionary{
    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");
        dictionary.addWord("pad");
        dictionary.search("bad");
    }
}