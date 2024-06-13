package Sequence;

public class Test0130 {
}

class Solution0130_1 {
    public void solve(char[][] board) {
        int m = board.length,n = board[0].length;
        for(int i = 0;i < m;i++) {
            dfs(board,i,0);
            dfs(board,i,n - 1);
        }
        for(int j = 1;j < n - 1;j++) {
            dfs(board,0,j);
            dfs(board,m - 1,j);
        }
        replaceBoard(board,'O','X');
        replaceBoard(board,'P','O');
    }

    private void replaceBoard(char[][] board,char src,char target) {
        for(int i = 0;i < board.length;i++) {
            for(int j = 0;j < board[0].length;j++) {
                if(board[i][j] == src) {
                    board[i][j] = target;
                }
            }
        }
    }

    private void dfs(char[][] board,int i,int j) {
        if(i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] != 'O') return;
        board[i][j] = 'P';
        dfs(board,i + 1,j);
        dfs(board,i - 1,j);
        dfs(board,i,j + 1);
        dfs(board,i,j - 1);
    }
}