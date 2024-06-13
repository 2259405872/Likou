package Sequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test0133 {
}

class Solution0133_1 {
    Map<Node2,Node2> map=new HashMap<Node2,Node2>();
    public Node2 cloneGraph(Node2 node) {
        if (node==null) return null;
        Node2 result = new Node2(node.val, new ArrayList<Node2>());
        map.put(node,result);

        for (Node2 neighbor : node.neighbors) {
            Node2 newNode = map.get(neighbor);
            if (newNode!=null) {
                result.neighbors.add(newNode);
            }else {
                newNode = cloneGraph(neighbor);
                result.neighbors.add(newNode);
            }
        }
        return result;
    }
}