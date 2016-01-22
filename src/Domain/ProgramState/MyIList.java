package Domain.ProgramState;

/**
 * Created by Live on 11/4/2015.
 */

public interface MyIList<T> extends java.io.Serializable {

    public void add(T item);

    public T get(int pos);

    public T remove(int pos);

    public int size();

    public boolean isEmpty();
}
