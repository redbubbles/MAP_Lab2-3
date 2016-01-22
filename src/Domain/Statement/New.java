package Domain.Statement;

import Domain.Expression.Exp;
import Domain.ProgramState.*;

/**
 * Created by Live on 12/6/2015.
 */
public class New implements IStmt {
    public String var;
    public Exp exp;

    public New(String var, Exp exp) {
        this.var = var;
        this.exp = exp;
    }

    public String toStr() {
        return "new(" + var + " , " + exp.toStr() + ")";
    }

    public PrgState execute(PrgState state) {
        Exp e = this.exp;
        MyIDictionary symTbl = state.getSymTable();
        IHeap heap = state.getHeap();
        String v = this.var;
        Integer index = heap.size();
        Integer val = e.eval(symTbl, heap);

        if (symTbl.isDefined(v))
            symTbl.update(v, index);
        else {
            MyMap m = new MyMap(v, index);
            symTbl.add(m);
        }
        HMap h = new HMap(index, val);
        heap.add(h);

        return state;
    }
}
