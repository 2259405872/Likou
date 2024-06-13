package Sequence;

public class Test0208 {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");
    }
}

class Trie01 {
    private boolean isTail;
    private final Trie01[] nodes;

    public Trie01() {
        isTail=false;
        nodes=new Trie01[26];
    }

    public void insert(String word) {
        if (word.length()==0) return;

        char c = word.charAt(0);
        int flag = c - 'a';
        Trie01 t =nodes[flag];

        if (t == null){
            t=new Trie01();
            nodes[flag]=t;
        }

        t.insert(word,1);
    }

    private void insert(String word,int index) {
        if (index==word.length()) {
            this.isTail=true;
            return;
        }

        char c = word.charAt(index);
        int flag = c - 'a';
        Trie01 t =nodes[flag];

        if (t == null){
            t=new Trie01();
            nodes[flag]=t;
        }

        t.insert(word,++index);
    }

    public boolean startsWith(String prefix) {
        if (prefix.length()==0) return true;

        char c = prefix.charAt(0);
        int flag = c - 'a';

        Trie01 t;
        if ((t=nodes[flag])==null) return false;

        return t.startsWith(prefix,1);
    }

    private boolean startsWith(String prefix,int index) {
        if (prefix.length()==index) return true;

        char c = prefix.charAt(index);
        int flag = c - 'a';

        Trie01 t;
        if ((t=nodes[flag])==null) return false;

        return t.startsWith(prefix,++index);
    }
    public boolean search(String word) {
        if (word.length()==0) return false;

        char c = word.charAt(0);
        int flag = c - 'a';

        Trie01 t;
        if ((t=nodes[flag])==null) return false;

        return t.search(word,1);
    }

    private boolean search(String word,int index){
        if (index==word.length()) return isTail;

        char c = word.charAt(index);
        int flag = c - 'a';

        Trie01 t;
        if ((t=nodes[flag])==null) return false;

        return t.search(word,++index);
    }
}

class Trie {
    boolean isWord;
    Trie[] tries;
    public Trie() {
        isWord=false;
        tries =new Trie[26];
    }

    public void insert(String word) {
        Trie trie = this;
        for (char c : word.toCharArray()) {
            Trie temp = trie.tries[c - 'a'];
            if (temp==null) {
                temp = new Trie();
                trie.tries[c-'a'] = temp;
            }

            trie=temp;
        }

        trie.isWord=true;
    }

    public boolean search(String word) {
        Trie trie = this;
        for (char c : word.toCharArray()) {
            Trie temp = trie.tries[c - 'a'];
            if (temp==null) return false;

            trie=temp;
        }

        return trie.isWord;
    }

    public boolean startsWith(String prefix) {
        Trie trie = this;
        for (char c : prefix.toCharArray()) {
            Trie temp = trie.tries[c - 'a'];
            if (temp==null) return false;

            trie=temp;
        }

        return true;
    }
}