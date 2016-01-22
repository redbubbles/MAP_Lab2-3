package Domain.ProgramState;


/**
 * Created by Live on 11/4/2015.
 */
public class MyArrayDictionary implements MyIDictionary<MyMap> {
    private static final int INITSIZE = 10;  // initial array size
    private MyMap[] items; // the items in the stack
    private int numItems;   // the number of items in the stack

    public MyArrayDictionary() {
        items = new MyMap[20];
        numItems = 0;
    }

    public boolean isEmpty() {
        if (numItems == 0)
            return true;
        return false;
    }

    public int getLength() {
        return numItems;
    }

    public MyMap get(int i) {
        return items[i];
    }

    public int lookup(String id) {
        for (int k = 0; k < numItems; k++)
            if (items[k].getID() == id)
                return items[k].getVal();
        return 0;//return error later :)
    }

    public boolean isDefined(String id) {
        for (int k = 0; k < numItems; k++)
            if (items[k].getID() == id)
                return true;
        return false;
    }

    public void update(String id, Integer val) {
        for (int k = 0; k < numItems; k++)
            if (items[k].getID() == id)
                items[k].setVal(val);
    }

    public void add(MyMap item) {
        if (items.length == numItems) {
            expandArray();
        }
        items[numItems] = item;
        numItems++;
    }

    public String toStr() {
        String s = "{";
        for (int i = 0; i < numItems; i++) {
            s += items[i].toStr() + ", ";
        }
        s += "}";
        return s;
    }

    private void expandArray() {
        MyMap[] newArray = (new MyMap[numItems * 2]);
        for (int k = 0; k < numItems; k++) {
            newArray[k] = items[k];
        }
        items = newArray;
    }


}
