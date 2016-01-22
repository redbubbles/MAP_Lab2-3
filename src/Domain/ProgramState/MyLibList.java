package Domain.ProgramState;

import java.util.ArrayList;

/**
 * Created by Live on 11/26/2015.
 */
public class MyLibList<T> implements MyIList<Integer> {

    private ArrayList<Integer> items;

    public MyLibList() {
        items = new ArrayList<Integer>();
    }

    public void add(Integer item) {
        items.add(item);
    }

    public Integer get(int pos) {
        return items.get(pos);
    }

    public Integer remove(int pos) {
        Integer x = items.get(pos);
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
