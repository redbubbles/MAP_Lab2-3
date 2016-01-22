package Domain.Expression;

import Domain.ProgramState.IHeap;
import Domain.ProgramState.MyIDictionary;

/**
 * Created by Live on 11/4/2015.
 */
public class ConstExp extends Exp {
    public int number;

    public ConstExp(int nr) {
        number = nr;
    }

    public int eval(MyIDictionary tbl, IHeap heap) {
        return number;
    }

    public String toStr() {
        return Integer.toString(number);
    }
}
