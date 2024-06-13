package Sequence;

import java.util.*;

public class Test0380 {
}

class RandomizedSet {
    private List<Integer> numbers;
    private Map<Integer,Integer> map;
    private int size;
    private Random random;
    public RandomizedSet() {
        numbers = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
        int size=0;
        random = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val,size);
        numbers.add(val);
        size++;
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index = map.get(val);
        int last = numbers.get(--size);
        map.put(last,index);
        map.remove(val);
        numbers.remove(last);
        numbers.set(index,last);
        numbers.remove(size);
        return true;
    }

    public int getRandom() {
        return numbers.get(random.nextInt(size));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */