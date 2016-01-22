package Domain.ProgramState;

/**
 * Created by Live on 11/4/2015.
 */

import Domain.Statement.IStmt;

import java.util.EmptyStackException;

/**
 * Created by Live on 11/2/2015.
 */
public class MyArrayStack implements MyIStack<IStmt> {
    // *** fields ***
    private static final int INITSIZE = 30; // initial array size
    private IStmt[] items; // the items in the stack
    private int numItems;   // the number of items in the stack


    // *** constructor ***
    public MyArrayStack() {
        items = new IStmt[INITSIZE];
        numItems = 0;
    }

    // *** StackADT methods ***

    // isEmpty

    public boolean isEmpty() {
        if (numItems == 0)
            return true;
        return false;
    }

    // add items
    public void push(IStmt item) {
        if (items.length == numItems) {
            expandArray();
        }
        items[numItems] = item;
        numItems++;
    }

    public int getLength() {
        return numItems;
    }

    public IStmt get(int i) {
        return items[i];
    }

    // remove items
    public IStmt pop() {
        if (numItems == 0) {
            System.out.println("pop empty list");
        } else {
            numItems--;
            return items[numItems];
        }

        return null;
    }

    public String toStr() {
        String s = "{";
        for (int i = numItems - 1; i >= 0; i--) {
            s += items[i].toStr();
        }
        s += "}";
        return s;
    }

    //additional method
    private void expandArray() {
        IStmt[] newArray = (IStmt[]) (new IStmt[numItems * 2]);
        for (int k = 0; k < numItems; k++) {
            newArray[k] = items[k];
        }
        items = newArray;
    }


}
