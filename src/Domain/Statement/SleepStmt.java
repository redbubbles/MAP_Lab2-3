package Domain.Statement;

import Domain.ProgramState.MyIStack;
import Domain.ProgramState.PrgState;

/**
 * Created by Live on 1/20/2016.
 */
public class SleepStmt implements IStmt {

    public int number;

    public SleepStmt(int n) {
        number = n;
    }

    public String toStr() {
        return "Sleep(" + number + ") ";
    }

    public PrgState execute(PrgState state) {
        if (number != 0) {
            MyIStack stk = state.getStk();
            IStmt i = new SleepStmt(number - 1);
            stk.push(i);
        }
        return state;

    }
}