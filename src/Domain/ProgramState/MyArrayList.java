package Domain.ProgramState;

/**
 * Created by Live on 11/4/2015.
 */

public class MyArrayList implements MyIList<Integer> {
    // *** fields ***
    private Integer[] items; // the items in the List
    private int numItems;   // the number of items in the List

    // *** constructor ***
    private static final int INITSIZE = 10;

    public MyArrayList() {
        numItems = 0;
        items = new Integer[INITSIZE];
    }

    //*** required ListADT methods ***

    public void add(Integer item) {
        // if array is full, get new array of double size,
        // and copy items from old array to new array
        if (items.length == numItems) {
            expandArray();
        }
        // add new item; update numItems
        items[numItems] = item;
        numItems++;
    }

    // get items
    public Integer get(int pos) {
        // check for bad pos
        if (pos < 0 || pos >= numItems) {
            //throw new IndexOutOfBoundsException();
        }

        // return the item at pos
        return items[pos];
    }

    // remove items
    public Integer remove(int pos) {
        // check for bad pos
        if (pos < 0 || pos >= numItems) {
            // throw new IndexOutOfBoundsException();
        }

        // get the item to be removed from pos
        Integer ob = items[pos];

        // move items over to fill removed pos
        for (int k = pos; k < numItems - 1; k++) {
            items[k] = items[k + 1];
        }

        // decrease the number of items
        numItems--;

        // return the removed item
        return ob;
    }

    public int size() {
        return numItems;
    }

    public boolean isEmpty() {
        if (numItems == 0)
            return true;
        return false;
    }

    // other methods

    // expandArray
    //   o Get a new array of twice the current size.
    //   o Copy the items from the old array to the new array.
    //   o Make the new array be this List's "items" array.
    //**********************************************************************
    private void expandArray() {
        Integer[] newArray = new Integer[numItems * 2];
        for (int k = 0; k < numItems; k++) {
            newArray[k] = items[k];
        }
        items = newArray;
    }


}
