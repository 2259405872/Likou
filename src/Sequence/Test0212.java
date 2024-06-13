package Sequence;

import java.util.ArrayList;
import java.util.List;

public class Test0212 {
    public static void main(String[] args){
        new Solution0212_1().findWords(new char[][]{
                        {'o','a','a','n'},
                        {'e','t','a','e'},
                        {'i','h','k','r'},
                        {'i','f','l','v'}
                },
                new String[]{"oath","eat"}
                );
    }
}

class Solution0212_1 {
    char[][] board;
    List<String> result;

    public List<String> findWords(char[][] board, String[] words) {
        this.result=new ArrayList<String>();
        this.board=board;

        Tire1 tire = new Tire1();
        for (String word : words) {
            tire.addWord(word);
        }

        for (int i = 0; i < board.length; i++) {
            char[] dots = board[i];
            for (int j = 0; j < dots.length; j++) {
                searchWord(i, j, tire);
            }
        }

        return result;
    }

    private void searchWord(int i,int j,Tire1 tire) {
        if (!isInBoard(i,j)||board[i][j]==0) return;

        char c = board[i][j];
        board[i][j]=0;

        int flag = c - 'a';
        Tire1 temp = tire.tires[flag];
        if (temp!=null){
            if (temp.value!=null){
                result.add(temp.value);
                temp.value=null;
            }

            if (temp.count == 0){
                tire.tires[flag]=null;
                tire.count--;
            }else {
                searchWord(i-1,j,temp);
                searchWord(i+1,j,temp);
                searchWord(i,j-1,temp);
                searchWord(i,j+1,temp);
            }
        }
        board[i][j]=c;
    }

    private boolean isInBoard(int i, int j) {
        return i<board.length&&i>=0&&j< board[0].length&&j>=0;
    }

    class Tire1{
        int count;
        String value;
        Tire1[] tires;

        public Tire1() {
            this.count = 0;
            this.tires = new Tire1[26];
        }

        public void addWord(String word) {
            char[] chars = word.toCharArray();
            Tire1 temp=this;

            for (char c : chars) {
                Tire1[] words1 = temp.tires;
                int index = c - 'a';
                Tire1 w = words1[index];

                if (w==null){
                    w= words1[index]=new Tire1();
                    temp.count++;
                }
                temp=w;
            }


            temp.value=word;
        }
    }
}