package Domain.ProgramState;

import Domain.Statement.IStmt;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by Live on 11/24/2015.
 */

public class MyLibStack<T> implements MyIStack<IStmt> {
    private Stack<IStmt> items;

    public MyLibStack() {
        items = new Stack<IStmt>();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void push(IStmt item) {
        items.push(item);
    }

    public int getLength() {
        return items.size();
    }

    public IStmt get(int i) {
        return items.get(i);
    }

    public IStmt pop() {
        return items.pop();
    }

    public String toStr() {
        String s = "{";
        IStmt k;
        for (int i = items.size() - 1; i >= 0; i--) {
            k = items.get(i);
            s += k.toStr() + ", ";
        }
        s += "}";
        return s;
    }


}