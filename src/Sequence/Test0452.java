package Sequence;

import java.util.Arrays;
import java.util.Comparator;

public class Test0452 {
    public static void main(String[] args) {
        new Solution0452_1().findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}});
    }
}

class Solution0452_1 {
    public int findMinArrowShots(int[][] points) {
        int result=0;
        if (points.length==0) return result;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]>o2[0]?1:-1;
            }
        });

        int max=points[0][1];

        for (int[] point : points) {
            if (max<point[0]){
                result++;
                max = point[1];
            }else {
                max=Math.min(max,point[1]);
            }
        }

        return ++result;
    }
}