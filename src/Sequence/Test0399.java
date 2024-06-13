package Sequence;

import java.util.*;

public class Test0399 {
}

class Solution0399_1 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int len1 = equations.size();
        int len2 = queries.size();

        double[] result = new double[len2];

        HashMap<String, Integer> indexMap = new HashMap<>();
        int count = 0;
        for (List<String> equation : equations) {
            String s1 = equation.get(0);
            String s2 = equation.get(1);

            indexMap.put(s1, count++);
            indexMap.put(s2, count++);
        }

        List<Pair>[] edges = new List[count];

        for (int i = 0; i < count; i++) {
            edges[i] = new ArrayList<Pair>();
        }


        for (int i = 0; i < len1; i++) {
            List<String> strings = equations.get(i);
            Integer index1 = indexMap.get(strings.get(0));
            Integer index2 = indexMap.get(strings.get(2));

            double v = values[i];

            edges[index1].add(new Pair(index2, v));
            edges[index2].add(new Pair(index1, 1/v));
        }

        for (int i = 0; i < len2; i++) {
            List<String> query = queries.get(i);
            Integer index1 = indexMap.get(query.get(0));
            Integer index2 = indexMap.get(query.get(1));

            double sam=-1.0;

            if (index2!=null&&index1!=null){
                if (index2.equals(index1)){
                    sam = 1.0;
                }else {
                    Deque<Integer> tmp = new LinkedList<>();
                    tmp.offer(index1);

                    double[] inter=new double[count];
                    Arrays.fill(inter, -1.0);
                    inter[index1]=1;

                    while (!tmp.isEmpty()&&inter[index2]!=-1.0){
                        int x = tmp.poll();
                        for (Pair pair : edges[x]) {
                            int y = pair.index;
                            if (inter[y]==-1){
                                tmp.offer(y);
                                inter[y]= pair.val*inter[x];
                            }
                        }
                    }
                    sam=inter[index2];

                }
            }

            result[i]=sam;

        }

        return result;
    }

    class Pair {
        int index;
        double val;

        public Pair(int index, double val) {
            this.index = index;
            this.val = val;
        }
    }
}