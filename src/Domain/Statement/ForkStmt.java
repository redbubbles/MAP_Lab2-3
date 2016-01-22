package Domain.Statement;

import Domain.ProgramState.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Live on 1/4/2016.
 */
public class ForkStmt implements IStmt {
    public IStmt stmt;

    public ForkStmt(IStmt s) {
        stmt = s;
    }

    public String toStr() {
        return "Fork(" + stmt.toStr() + ") ";
    }


    public PrgState execute(PrgState state) {

        MyIStack<IStmt> stack = new MyLibStack<IStmt>();
        stack.push(stmt);

        MyIDictionary<MyMap> symtable = new MyLibDictionary<HMap>();
        symtable = state.symTable;

        MyIList<Integer> printList = new MyLibList<Integer>();

        IStmt crtstm = state.originalProgram;

        IHeap<HMap> h = state.heap;

        PrgState childPrgState = new PrgState(stack, symtable, printList, h, crtstm);

        childPrgState.id = state.id * 10;

        List<PrgState> x = new ArrayList<>();

        return childPrgState;
    }
}
