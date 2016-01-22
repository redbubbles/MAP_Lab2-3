package Domain.Expression;

import Domain.ProgramState.IHeap;
import Domain.ProgramState.MyIDictionary;

/**
 * Created by Live on 11/4/2015.
 */
public class VarExp extends Exp {
    String id;

    public VarExp(String id) {
        this.id = id;

    }

    public int eval(MyIDictionary tbl, IHeap heap) {
        return tbl.lookup(id);
    }


    public String toStr() {
        return id;

    }


}
