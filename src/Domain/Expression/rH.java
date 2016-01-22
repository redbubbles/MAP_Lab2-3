package Domain.Expression;

import Domain.ProgramState.IHeap;
import Domain.ProgramState.MyIDictionary;

import java.util.NoSuchElementException;

/**
 * Created by Live on 12/8/2015.
 */
public class rH extends Exp {
    public String var;

    public rH(String v) {
        var = v;
    }

    public String toStr() {
        return var;
    }

    public int eval(MyIDictionary tbl, IHeap heap) {
        int content = 0;
        int address = tbl.lookup(var);
        try {
            content = heap.get(content);
        } catch (NoSuchElementException e) {
            return 0;
        }
        ;

        return content;
    }
}
