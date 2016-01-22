package Domain.Expression;

import Domain.ProgramState.IHeap;
import Domain.ProgramState.MyIDictionary;

import java.io.Serializable;

/**
 * Created by Live on 11/4/2015.
 */
public abstract class Exp implements Serializable {


    public int eval(MyIDictionary tbl, IHeap heap) {
        return 0;
    }

    public abstract String toStr();
}
