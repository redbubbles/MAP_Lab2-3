package Domain.Statement;

import Domain.Expression.Exp;
import Domain.ProgramState.HMap;
import Domain.ProgramState.IHeap;
import Domain.ProgramState.MyIDictionary;
import Domain.ProgramState.PrgState;

import java.util.NoSuchElementException;

/**
 * Created by Live on 12/8/2015.
 */
public class wH implements IStmt {
    public String var;
    public Exp exp;

    public wH(String var, Exp exp) {
        this.exp = exp;
        this.var = var;
    }

    public String toStr() {
        return var + " -> " + exp.toStr();
    }

    public PrgState execute(PrgState state) {
        MyIDictionary symTbl = state.getSymTable();
        IHeap heap = state.getHeap();
        int address = symTbl.lookup(this.var);
        try {
            HMap h = (HMap) heap.getElement(address);
            h.setA(address);
            h.setC(exp.eval(symTbl, heap));
        } catch (NoSuchElementException e) {
        }
        return state;
    }
}
