package Sequence;

public class Test0427 {
}

class Solution0427_1 {
    int[][] grid;
    private static final Node4 zero = new Node4(false, true);
    private static final Node4 one = new Node4(true, true);
    public Node4 construct(int[][] grid) {
        this.grid=grid;
        int length = grid.length;
        return build(0, length-1,0,length-1);
    }

    public Node4 build(int columnStart,int columnEnd,int rowStart,int rowEnd) {
        if (columnStart==columnEnd&&rowEnd==rowStart) return grid[rowStart][columnStart]==1?one:zero;

        int columnMid = (columnStart + columnEnd) / 2;
        int rowMid = (rowStart + rowEnd) / 2;

        Node4 topLeft = build(columnStart, columnMid, rowStart, rowMid);
        Node4 topRight = build(columnMid + 1, columnEnd, rowStart, rowMid);
        Node4 bottomLeft = build(columnStart, columnMid, rowMid + 1, rowEnd);
        Node4 bottomRight = build(columnMid + 1, columnEnd, rowMid + 1, rowEnd);

        if (topLeft==one&&bottomLeft==one&&topRight==one&&bottomRight==one) return one;
        if (topLeft==zero&&bottomLeft==zero&&topRight==zero&&bottomRight==zero) return zero;

        return new Node4(false,false,topLeft,topRight,bottomLeft,bottomRight);
    }
}