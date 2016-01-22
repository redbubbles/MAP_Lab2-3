package Domain.ProgramState;

import java.io.Serializable;

/**
 * Created by Live on 11/4/2015.
 */
public interface MyIDictionary<T> extends Serializable {

    int lookup(String id);

    boolean isDefined(String id);

    void update(String id, Integer val);

    void add(T item);

    public int getLength();

    public String toStr();

    public MyMap get(int i);


}
