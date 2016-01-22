package Domain.Statement;

import Domain.Expression.Exp;
import Domain.ProgramState.IHeap;
import Domain.ProgramState.MyIDictionary;
import Domain.ProgramState.MyIList;
import Domain.ProgramState.PrgState;

/**
 * Created by Live on 11/4/2015.
 */


public class PrintStmt implements IStmt {
    public Exp exp;

    public PrintStmt(Exp exp) {
        this.exp = exp;
    }

    public String toStr() {
        return "print(" + exp.toStr() + ")";
    }

    public PrgState execute(PrgState state) {
        MyIList list = state.getPrintList();
        MyIDictionary dict = state.getSymTable();
        IHeap heap = state.getHeap();
        list.add(exp.eval(dict, heap));
        return state;
    }

}
