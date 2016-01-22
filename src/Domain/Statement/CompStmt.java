package Domain.Statement;

import Domain.ProgramState.MyIStack;
import Domain.ProgramState.PrgState;

/**
 * Created by Live on 11/4/2015.
 */


public class CompStmt implements IStmt {
    public IStmt first;
    public IStmt snd;

    public CompStmt(IStmt first, IStmt second) {
        this.first = first;
        this.snd = second;
    }

    public String toStr() {

        return "Comp(" + first.toStr() + "; " + snd.toStr() + ")";
    }

    public PrgState execute(PrgState state) {
        MyIStack stk = state.getStk();
        stk.push(this.snd);
        stk.push(this.first);
        return state;
    }
}
