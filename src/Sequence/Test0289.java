package Sequence;

public class Test0289 {
    public static void main(String[] args) {
        new Solution0289_2().gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }
}

class Solution0289_1 {
    public void gameOfLife(int[][] board) {
        int len1 = board.length;
        int len2 = board[0].length;

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                int flag=0;
                int r=i-1>=0 ? -1 : 0;
                int r2=i+1<len1 ? 1 : 0;
                int c=j-1>=0 ? -1 : 0;
                int c2=j+1<len2 ? 1 : 0;

                for(int r1=r;r1<=r2;r1++) {
                    for(int c1=c;c1<=c2;c1++) {
                        if(!(r1==0&&c1==0)){
                            if(board[i+r1][j+c1]==2||board[i+r1][j+c1]==1) flag++;
                        }
                    }
                }

                if (board[i][j]==0){
                    if(flag==3) board[i][j]=3;
                }else {
                    if (!(flag==2||flag==3)) board[i][j]=2;
                }
            }
        }

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j <len2; j++) {
                int n = board[i][j];
                if (n==2) board[i][j]=0;
                if (n==3) board[i][j]=1;
            }
        }
    }
}

class Solution0289_2 {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                calculateState(i,j,board);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]==-1) board[i][j]=1;
                if (board[i][j]==2) board[i][j]=0;
            }
        }

    }

    public void calculateState(int i,int j,int[][] board){
        int oldState =board[i][j],count=0,
                t=i-1>=0?i-1:i,
                b=i+1< board.length?i+1:i,
                r=j+1< board[0].length?j+1:j,
                l=j-1>=0?j-1:j;

        for (int i1=t;i1<=b;i1++){
            for (int i2=l;i2<=r;i2++){
                if (board[i1][i2]>0) count++;
            }
        }

        count-=oldState;

        if (oldState==0){
            if (count==3) board[i][j]=-1;
        }else {
            if (count!=3&&count!=2) board[i][j]++;
        }

    }
}