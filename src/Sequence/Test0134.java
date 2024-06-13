package Sequence;

public class Test0134 {
}

class Solution0134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=-1;
        int surplus=0;
        int index=0;
        boolean b=true;

        while (b){
            int index1=index%cost.length;
            if(surplus+gas[index1]<cost[index1]){
                if(index>=cost.length){
                    b=false;
                }
                start=-1;
                surplus=0;
            } else if (index1==start) {
                b=false;
            } else if (start != -1) {
                surplus=surplus-cost[index1]+gas[index1];
            }else {
                start=index;
                surplus=surplus-cost[index1]+gas[index1];
            }
            index++;
        }

        return start;
    }
}
