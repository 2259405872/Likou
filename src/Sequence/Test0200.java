package Sequence;

public class Test0200 {
}

class Solution0200_1 {
    char[][] grid;
    int rL;
    int cL;
    public int numIslands(char[][] grid) {
        int result =0;
        this.grid=grid;
        rL=grid.length;
        if (rL == 0) return result;
        cL=grid[0].length;
        for (int i = 0; i < rL; i++) {
            for (int j = 0; j < cL; j++) {
                if (grid[i][j]=='1') {
                    result++;
                    fullLand(i,j);
                }
            }
        }

        return result;
    }

    public void fullLand(int r,int c){
        if (!inArea(r,c)||grid[r][c]=='0') return;
        grid[r][c] = '0';

        fullLand(r+1,c);
        fullLand(r-1,c);
        fullLand(r,c+1);
        fullLand(r,c-1);
    }

    public boolean inArea(int r,int c){
        return r>=0&&r<rL&& c<cL&&c>=0;
    }
}

class Solution0200 {
    public int numIslands(char[][] grid) {
        int ans=0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1'){
                    mark( i, j, grid);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void mark(int r,int c,char[][]grid){
        if (isInLand(r, c, grid)){
            grid[r][c] ='2';
            mark(r+1, c, grid);
            mark(r-1, c, grid);
            mark(r, c-1, grid);
            mark(r, c+1, grid);
        }
    }

    public boolean isInLand(int r,int c,char[][]grid){
        if (r<0||r>=grid.length||c<0||c>=grid[0].length) return false;
        else return grid[r][c]=='1';
    }
}
