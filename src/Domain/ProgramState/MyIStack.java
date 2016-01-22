package Domain.ProgramState;

import Domain.Statement.IStmt;

import java.util.EmptyStackException;

/**
 * Created by Live on 11/4/2015.
 */

public interface MyIStack<T> extends java.io.Serializable {

    public boolean isEmpty();

    public void push(T item);

    public int getLength();

    public T get(int i);

    public T pop();

    public String toStr();


}
