package Domain.Statement;

import Domain.Expression.Exp;
import Domain.ProgramState.IHeap;
import Domain.ProgramState.MyIDictionary;
import Domain.ProgramState.MyMap;
import Domain.ProgramState.PrgState;

/**
 * Created by Live on 11/4/2015.
 */


public class AssignStmt implements IStmt {
    public String id;
    public Exp exp;

    public AssignStmt(String id, Exp exp) {
        this.id = id;
        this.exp = exp;
    }

    public String toStr() {
        return id + " -> " + exp.toStr();
    }

    public PrgState execute(PrgState state) {
        Exp e = this.exp;
        MyIDictionary symTbl = state.getSymTable();
        String id = this.id;
        IHeap h = state.getHeap();
        Integer val = e.eval(symTbl, h);
        if (symTbl.isDefined(id))
            symTbl.update(id, val);
        else {
            MyMap m = new MyMap(id, val);
            symTbl.add(m);
        }
        return state;
    }
}