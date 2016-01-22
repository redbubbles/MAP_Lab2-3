package Domain.Statement;

import Domain.Expression.Exp;
import Domain.ProgramState.MyIStack;
import Domain.ProgramState.PrgState;

/**
 * Created by Live on 11/27/2015.
 */
public class WhileStmt implements IStmt {
    public Exp exp;
    public IStmt[] stmt;

    public WhileStmt(Exp e, IStmt... s) {
        stmt = s;
        exp = e;

    }

    public String toStr() {
        String s = "WHILE( " + exp.toStr() + " )";
        for (IStmt i : stmt)
            s += i.toStr() + ",";
        s += ")";
        return s;
    }

    public PrgState execute(PrgState state) {
        MyIStack stk = state.getStk();
        IStmt[] s = this.stmt;
        int k = exp.eval(state.getSymTable(), state.getHeap());

        while (k != 0) {
            for (int i = 0; i < s.length; i++) {
                stk.push(s[i]);
            }
            k--;
        }
        return state;
    }

}
