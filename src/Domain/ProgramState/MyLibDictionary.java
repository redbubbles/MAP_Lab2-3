package Domain.ProgramState;

import java.util.*;


/**
 * Created by Live on 11/27/2015.
 */

public class MyLibDictionary<T> implements MyIDictionary<MyMap> {

    private Map<String, Integer> items;

    public MyLibDictionary() {
        items = new HashMap<String, Integer>();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int lookup(String id) {
        return items.get(id);
    }

    public boolean isDefined(String id) {
        return items.containsKey(id);
    }

    public void update(String id, Integer val) {
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            if (entry.getKey() == id)
                entry.setValue(val);
        }
    }

    public void add(MyMap m) {

        items.put(m.id, m.val);
    }

    public int getLength() {
        return items.size();
    }

    public MyMap get(int i) {
        MyMap x = null;
        int k = 0;
        Iterator entries = items.entrySet().iterator();
        while (entries.hasNext()) {
            if (i == k) {
                Map.Entry thisEntry = (Map.Entry) entries.next();
                String key = (String) thisEntry.getKey();
                Integer value = (Integer) thisEntry.getValue();
                x = new MyMap(key, value);
                break;
            }
            k++;
        }
        return x;
    }


    public String toStr() {
        String s = "{";
        MyMap x = null;
        Iterator entries = items.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry thisEntry = (Map.Entry) entries.next();
            String key = (String) thisEntry.getKey();
            Integer value = (Integer) thisEntry.getValue();
            x = new MyMap(key, value);
            s += x.toStr() + " ,";
        }
        s += "}";
        return s;
    }


}