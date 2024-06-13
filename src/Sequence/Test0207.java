package Sequence;

import java.util.*;

public class Test0207 {
    public static void main(String[] args) {
        new Solution0207_3().canFinish(5,new int[][]{{1,0},{2,1},{3,4},{4,3}});
    }
}

//广度优先遍历
class Solution0207_1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int flag =numCourses;
        int[] grades = new int[numCourses];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int[] info : prerequisites) {
            grades[info[0]]++;
            list.get(info[1]).add(info[0]);
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < grades.length; i++) {
            if (grades[i]==0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            flag--;
            ArrayList<Integer> subjects = list.get(current);

            for (Integer subject : subjects) {
                if (--grades[subject]==0) queue.offer(subject);
            }

        }

        return flag==0;
    }
}

//深度优先遍历
class Solution0207_2 {
    List<List<Integer>> edges;
    int[] indeg;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            ++visited;
            int u = queue.poll();
            for (int v: edges.get(u)) {
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses;
    }
}

class Solution0207_3 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            lists.add(new ArrayList<Integer>());
        }
        int[] records = new int[numCourses];

        for (int[] prerequisite : prerequisites){
            if (prerequisite[0]==prerequisite[1]) return false;
            lists.get(prerequisite[0]).add(prerequisite[1]);
            records[prerequisite[0]]=1;
        }

        for (int i = 0; i < numCourses; i++) if (records[i]==1&&!dfs(lists,records,i)) return false;


        return true;
    }

    public boolean dfs(ArrayList<List<Integer>> lists,int[] record,int index){
        if (record[index]==2) return false;
        if (record[index]==0) return true;
        List<Integer> list = lists.get(index);
        record[index]++;

        for (int next : list) if (!dfs(lists,record,next)) return false;

        record[index]=0;
        return true;
    }
}