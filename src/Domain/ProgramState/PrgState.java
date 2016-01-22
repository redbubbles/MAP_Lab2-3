package Domain.ProgramState;

import Domain.Expression.ArithExp;
import Domain.Statement.IStmt;

/**
 * Created by Live on 11/4/2015.
 */


public class PrgState implements java.io.Serializable {
    public int id;
    public MyIStack exeStack;
    public MyIDictionary symTable;
    public MyIList out;
    public IStmt originalProgram; //optional field, but good to have
    public IHeap heap;

    public PrgState() {
        id = 0;
        exeStack = null;
        symTable = null;
        out = null;
        originalProgram = null;
        heap = null;
    }

    public PrgState(MyIStack stk, MyIDictionary symtbl, MyIList otp, IHeap heap, IStmt crtstm) {
        id++;
        exeStack = stk;
        symTable = symtbl;
        out = otp;
        this.heap = heap;
        originalProgram = crtstm;
        exeStack.push(crtstm);
    }


    public boolean isNotCompleted() {
        return !exeStack.isEmpty();
    }

    public PrgState oneStep() {
        IStmt crtStmt = null;
        if (exeStack.isEmpty()) {
            System.out.println("empty stack");
            return null;
        } else
            crtStmt = (IStmt) exeStack.pop();
        return crtStmt.execute(this);
    }

    public MyIStack getStk() {
        return exeStack;
    }

    public MyIDictionary getSymTable() {
        return symTable;
    }


    public MyIList getPrintList() {
        return out;
    }

    public IHeap getHeap() {
        return heap;
    }

    public String toStr() {
        String s = "";
        s = s + "state id:" + id + "\n \"ExeStack: " + exeStack.toStr() + "\n SymTbl: " + symTable.toStr() + "\n List: {";
        for (int i = 0; i < out.size(); i++)
            s = s + out.get(i) + " ; ";
        s = s + "}\n Heap: {";
        for (int i = 0; i < heap.size(); i++)
            s = s + heap.get(i) + " ; ";
        s = s + "}\n\n";

        System.out.print(s);
        return s;



  /*
        System.out.print("state id:");
        System.out.println(id);
        System.out.println("ExeStack");
        System.out.print("{");
     /*   for (int i = exeStack.getLength()-1;i>=0;i--) {
            IStmt k= (IStmt) exeStack.get(i);
            System.out.print(k.toStr() + " | ");
            System.out.print("} \n");

        }
      */

  /*
        System.out.print(exeStack.toStr()+ " \n ");

        //show the symTbl
        System.out.println("SymTbl");

        System.out.print(symTable.toStr()+"\n");

        //show the list of printed values

        System.out.println("List");
        System.out.print("{");
        for(int i= 0; i<out.size(); i++ )
            System.out.print(out.get(i) + " ; ");
        System.out.print("}\n");

        System.out.print("heap{");

        for(int i= 0; i<heap.size(); i++ ){
            System.out.print(heap.get(i) + " ; ");}
        System.out.print("}\n");
*/
    }


}
