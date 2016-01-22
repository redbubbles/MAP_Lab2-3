package Domain.ProgramState;

/**
 * Created by Live on 12/8/2015.
 */
public interface IHeap<T> extends java.io.Serializable {
    public void add(T item);

    public Integer get(int pos);

    public T remove(int pos);

    public int size();

    public T getElement(int pos);

    public boolean isEmpty();
}
