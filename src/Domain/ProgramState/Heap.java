package Domain.ProgramState;

import java.util.*;

/**
 * Created by Live on 12/8/2015.
 */
public class Heap<A, C> implements IHeap<HMap> {


    private ArrayList<HMap> items;

    public Integer index;

    public Heap() {
        items = new ArrayList<>();
        index = items.size();
    }

    public void add(HMap item) {
        items.add(item);
    }

    public Integer get(int pos) {
        return items.get(pos).getC();
    }

    public HMap getElement(int pos) {
        return items.get(pos);
    }

    public HMap remove(int pos) {
        HMap x = items.get(pos);
        items.remove(pos);
        return x;
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }


}
