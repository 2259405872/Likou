package Sequence;

import java.util.HashMap;
import java.util.Map;

public class Test0149 {
    public static void main(String[] args) {
        new Solution0149_1().maxPoints(new int[][]{{2,3},{3,3},{-5,3}});
    }
}

class Solution0149_1 {
    public int maxPoints(int[][] points) {
        int length = points.length;
        if (length<=2) return length;

        Map<Double, Integer> counts = new HashMap<>();
        int ans=0;
        int index=0;
        while (ans<length-index){
            int[] point1 = points[index];
            for (int i = ++index; i < points.length; i++) {
                int[] point2 = points[i];
                int b = point1[0] - point2[0];
                double t = point1[1] - point2[1];

                double dev=b==0?Integer.MAX_VALUE:t/b+0.0;
                Integer count = counts.get(dev);

                int newCount=count==null?2:count+1;
                ans=Math.max(ans,newCount);
                counts.put(dev,newCount);
            }
            counts.clear();
        }

        return ans;
    }
}