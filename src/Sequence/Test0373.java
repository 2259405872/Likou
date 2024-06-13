package Sequence;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Test0373 {
}

class Solution0373_1 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        ArrayList<List<Integer>> result = new ArrayList<>(k);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->nums1[a[0]]+nums2[a[1]]-nums1[b[0]]-nums2[b[1]]);
        int len = Math.min(nums1.length, k);
        for (int i = 0; i < len; i++) {
            queue.offer(new int[]{i,0});
        }

        for (int i = k; i > 0&&!queue.isEmpty(); i--) {
            int[] poll = queue.poll();
            int a = poll[0];
            int b = poll[1];
            result.add(List.of(nums1[a],nums2[b]));

            if (b<nums2.length-1){
                queue.offer(new int[]{a,b+1});
            }
        }

        return result;
    }
}