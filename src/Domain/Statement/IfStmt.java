package Domain.Statement;

import Domain.Expression.Exp;
import Domain.ProgramState.MyIStack;
import Domain.ProgramState.PrgState;


/**
 * Created by Live on 11/4/2015.
 */

public class IfStmt implements IStmt {
    public Exp exp;
    public IStmt thenS;
    public IStmt elseS;

    public IfStmt(Exp e, IStmt t, IStmt el) {
        exp = e;
        thenS = t;
        elseS = el;
    }

    public String toStr() {
        return "IF(" + exp.toStr() + ") THEN(" + thenS.toStr()
                + ")ELSE(" + elseS.toStr() + ")";
    }

    public PrgState execute(PrgState state) {
        MyIStack stk = state.getStk();
        IStmt thenStmt = this.thenS;
        IStmt elseStmt = this.elseS;
        if (exp.eval(state.getSymTable(), state.getHeap()) == 1)
            stk.push(thenStmt);
        else
            stk.push(elseStmt);
        return state;
    }

}
