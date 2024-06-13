package Sequence;

public class Test0079 {
}

class Solution0079 {
    char[] chars;
    char[][] board;
    public boolean exist(char[][] board, String word) {
        if (board.length==0) return false;
        this.chars = word.toCharArray();
        this.board =board;

        for (int i = 0; i < board.length; i++) {
            char[] b = board[i];
            for (int j = 0; j < b.length; j++) {
                if (isWord(0,i,j)) return true;
            }
        }

        return false;
    }

    public boolean isWord(int index,int i ,int j) {
        if (i < 0 || i >= board.length||j < 0 || j >= board[0].length||board[i][j]=='-') return false;

        char c = board[i][j];
        char c1 = chars[index];
        if (c1!=c) return false;

        if (index<chars.length-1){
            char temp = board[i][j];
            board[i][j] ='-';
            boolean b = isWord(index + 1, i - 1, j) ||
                    isWord(index + 1, i + 1, j) ||
                    isWord(index + 1, i, j - 1) ||
                    isWord(index + 1, i, j + 1);
            board[i][j] = temp;
            return b;
        }else {
            return true;
        }


    }
}

class Solution0079_02 {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (traverse(chars, board,0,i,j)) return true;

        return false;
    }

    public boolean traverse(char[] chars,char[][] board, int count, int i, int j) {
        if (count == chars.length) return true;
        if (i<0||j<0||i>=board.length||j>=board[0].length) return false;
        if (board[i][j]!=chars[count]) return false;

        char temp=board[i][j];
        board[i][j]='.';
        boolean b = traverse(chars, board, count + 1, i+1, j) ||
                traverse(chars, board, count + 1, i-1, j) ||
                traverse(chars, board, count + 1, i, j+1) ||
                traverse(chars, board, count + 1, i, j-1);
        board[i][j]=temp;

        return b;
    }
}
