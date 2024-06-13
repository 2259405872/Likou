package Sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test0210 {
    public static void main(String[] args) {
        int[] ints = new Solution0210_1().findOrder(2, new int[][]{{1,0}});
        Arrays.stream(ints).forEach(System.out::println);
    }
}
class Solution0210_1 {
    List<List<Integer>> list;
    int[] visited ;
    int[] result;
    int count = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        result=new int[numCourses];
        visited=new int[numCourses];
        list=new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int[] ints : prerequisites) {
            list.get(ints[0]).add(ints[1]);
        }

        for (int index = 0; index < numCourses; index++) {
            if (visited[index]==0){
                if (!dfs(index)) return new int[0];
            }
        }

        return result;
    }

    public boolean dfs(int index){
        List<Integer> subjects = list.get(index);
        visited[index]++;
        for (int subject :subjects){
            int flag = visited[subject];
            if (flag ==0){
                if (!dfs(subject)) return false;
            } else if (flag == 1) {
                return false;
            }
        }
        result[count++]=index;
        visited[index]++;
        return true;
    }
}