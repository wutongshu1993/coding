package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
    HashMap<Integer, Integer> valToIndex = new HashMap<>();
    ArrayList<Integer> valArr = new ArrayList<>();
    Random rand = new Random();
    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if(valToIndex.containsKey(val)){
            return false;
        }
        valToIndex.put(val,valArr.size());
        valArr.add(valArr.size(), val);
        return true;
    }

    public boolean remove(int val) {
        if(!valToIndex.containsKey(val)){
            return false;
        }
        int index = valToIndex.get(val);
        int temp = valArr.get(valArr.size()-1);
        valArr.set(index, temp);
        valToIndex.put(temp, index);

        valArr.remove(valArr.size()-1);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        return valArr.get(rand.nextInt(valArr.size()));
    }
}
